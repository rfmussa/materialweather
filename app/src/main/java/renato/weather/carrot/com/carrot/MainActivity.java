package renato.weather.carrot.com.carrot;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import java.util.List;
import java.util.concurrent.TimeUnit;

import renato.weather.carrot.com.carrot.events.EventBus;
import renato.weather.carrot.com.carrot.events.LocationChangeEvent;
import renato.weather.carrot.com.carrot.events.SavedLocationChange;
import renato.weather.carrot.com.carrot.rest.RestClient;
import renato.weather.carrot.com.carrot.rest.model.Location;
import renato.weather.carrot.com.carrot.rest.model.Locations;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.android.concurrency.AndroidSchedulers;
import rx.android.observables.ViewObservable;
import rx.functions.Action1;
import rx.functions.Func1;


public class MainActivity extends ActionBarActivity
{
	private final int SEARCH_DELAY = 300;
	private Dialog searchDialog;
	private RecyclerView searchRecyclerView;
	private RecyclerView drawerRecyclerView;
	private LocationManager locationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Setting toolbar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		if (toolbar != null)
		{
			setSupportActionBar(toolbar);
		}
		
		if (savedInstanceState == null)
		{
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new MainFragment())
					.commit();
		}

		drawerRecyclerView = (RecyclerView) findViewById(R.id.left_drawer);
		drawerRecyclerView.setHasFixedSize(true);

		LinearLayoutManager llm = new LinearLayoutManager(this);
		llm.setOrientation(LinearLayoutManager.VERTICAL);		
		drawerRecyclerView.setLayoutManager(llm);
		
		EventBus.getInstance().register(this);
		locationManager = LocationManager.getInstance(this);
		drawerRecyclerView.setAdapter(new LocationAdapter(locationManager.getLocations()));
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		searchDialog = createDialog();
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		if (id == R.id.action_search)
		{
			searchDialog.show();
		}

		return super.onOptionsItemSelected(item);
	}

	private void doSearch(String query)
	{
		if (!query.isEmpty() && query.length() > 2)
		{
			RestClient.getInstance().getAutoCompleteService().getLocations(query, new Callback<Locations>()
			{
				@Override
				public void success(Locations locations, Response response)
				{
					List<Location> locationList = locations.getLocationsList();
					
					if (locationList != null && locationList.size() > 0)
					{
						searchRecyclerView.setAdapter(new LocationAdapter(locations.getLocationsList()));
					}

					//TODO animate
					searchRecyclerView.setVisibility(locationList.size() > 0 ? View.VISIBLE : View.GONE);
					
				}

				@Override
				public void failure(RetrofitError error)
				{

				}
			});
		}
	}

	private Dialog createDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflater = this.getLayoutInflater();
		View v = inflater.inflate(R.layout.search_dialog, null);
		builder.setView(v);

		EditText locationText = (EditText) v.findViewById(R.id.location_search_text);

		searchRecyclerView = (RecyclerView) v.findViewById(R.id.location_list);
		searchRecyclerView.setHasFixedSize(true);

		LinearLayoutManager llm = new LinearLayoutManager(this);
		llm.setOrientation(LinearLayoutManager.VERTICAL);
		searchRecyclerView.setLayoutManager(llm);
		
		Observable<EditText> searchTextObservable = ViewObservable.text(locationText);
		searchTextObservable.debounce(SEARCH_DELAY, TimeUnit.MILLISECONDS)
				.map(new Func1<TextView, String>()
				{
					@Override
					public String call(TextView searchText)
					{
						return searchText.getText().toString();
					}
				})
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Action1<String>()
				{
					@Override
					public void call(String query)
					{
						doSearch(query);
					}
				}, new Action1<Throwable>()
				{
					@Override
					public void call(Throwable throwable)
					{
						//TODO handle error
						
					}
				});

		return builder.create();
	}

	@Subscribe
	public void locationChanged(LocationChangeEvent event) {
		if(searchDialog.isShowing())
		{
			searchDialog.dismiss();
		}
	}

	@Subscribe
	public void saveLocationChanged(SavedLocationChange event) 
	{
		drawerRecyclerView.setAdapter(new LocationAdapter(locationManager.getLocations()));
	}

}

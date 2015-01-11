package renato.weather.carrot.com.carrot;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import renato.weather.carrot.com.carrot.rest.RestClient;
import renato.weather.carrot.com.carrot.rest.model.Result;
import renato.weather.carrot.com.carrot.rest.model.Results;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observable;
import rx.android.observables.AndroidObservable;
import rx.android.observables.ViewObservable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;


public class MainActivity extends ActionBarActivity
{
	SearchView searchView;
	EditText editText;
	TextView searchText;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Setting toolbar
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		if (toolbar != null) {
			setSupportActionBar(toolbar);
		}
		
		if (savedInstanceState == null)
		{
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new MainFragment())
					.commit();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		//searchText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
		
		/*Observable<TextView> searchTextObservable = ViewObservable.text(searchText);
		searchTextObservable.debounce(300, TimeUnit.MILLISECONDS)
				.map(new Func1<TextView, String>()
				{
					@Override
					public String call(TextView searchText)
					{
						return searchText.getText().toString();
					}
				})
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Action1<String>() {
					@Override
					public void call(String query) {
						doSearch(query);
					}
				}, new Action1<Throwable>() {
					@Override
					public void call(Throwable throwable) {
						throwable.printStackTrace();
					}
				});
		*/
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
			openDialog().show();
		}

		return super.onOptionsItemSelected(item);
	}
	
	private void doSearch(String query)
	{
		if(!query.isEmpty() && query.length() > 2)
		{
			RestClient.getInstance().getAutoCompleteService().getLocations(query, new Callback<Results>()
			{
				@Override
				public void success(Results results, Response response)
				{

				}

				@Override
				public void failure(RetrofitError error)
				{

				}
			});
		}
	}
	
	private Dialog openDialog()
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		LayoutInflater inflater = this.getLayoutInflater();
		View v = inflater.inflate(R.layout.search_dialog, null);
		builder.setView(v);

		EditText et = (EditText) v.findViewById(R.id.ptnEdit);
		et.addTextChangedListener(new TextWatcher()
		{
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after)
			{
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count)
			{

			}

			@Override
			public void afterTextChanged(Editable s)
			{

			}
		});

		builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		return builder.create();
	}

}

package renato.weather.carrot.com.carrot;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;


public class MainActivity extends ActionBarActivity
{
	SearchView searchView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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

		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		/*if (id == R.id.action_settings)
		{
			return true;
		}*/

		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
/*	public static class PlaceholderFragment extends Fragment
	{
		TextView location_name;
		TextView condition_text;
		TextView temperature;
		TextView wind_text;
		TextView precipitation_text;
		
		WeatherImageView condition_image;
		ImageView wind_image;
		ImageView precipitation_image;
		
		RestClient restClient;
		
		public PlaceholderFragment()
		{
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
								 Bundle savedInstanceState)
		{
			View rootView = inflater.inflate(R.layout.view_current, container, false);
			
			location_name = (TextView) rootView.findViewById(R.id.location_name);
			condition_text = (TextView) rootView.findViewById(R.id.condition_text);
			temperature = (TextView) rootView.findViewById(R.id.temperature);
			wind_text = (TextView)  rootView.findViewById(R.id.wind_text);
			precipitation_text = (TextView) rootView.findViewById(R.id.precipitation_text);
			condition_image = (WeatherImageView) rootView.findViewById(R.id.condition_image);
			
			return rootView;
		}

		@Override
		public void onResume()
		{
			super.onResume();
			restClient = new RestClient();
		 restClient.getAutoCompleteService().getLocations("San Fr", new Callback<Results>()
		 {
			 @Override
			 public void success(Results results, Response response)
			 {
				 Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
			 }

			 @Override
			 public void failure(RetrofitError error)
			 {
				 Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();
			 }
		 });

			restClient.getApiService().getCondition("zmw:94101.1.99999", new Callback<ObservationResponse>()
			{
				@Override
				public void success(ObservationResponse data, Response response)
				{
					location_name.setText("San Francisco");
					condition_text.setText(data.getCurrentObservation().getWeather());
					wind_text.setText(data.getCurrentObservation().getWindGustKph());
					precipitation_text.setText(data.getCurrentObservation().getRelativeHumidity());
					temperature.setText(data.getCurrentObservation().getTempC() + " C");
					condition_image.setCondition(data.getCurrentObservation().getIcon());
					restClient.getApiService().getHourlyCondition("zmw:94101.1.99999", new Callback<Forecasts>()
					{
						@Override
						public void success(Forecasts forecasts, Response response)
						{
							
						}

						@Override
						public void failure(RetrofitError error)
						{

						}
					});
				}

				@Override
				public void failure(RetrofitError error)
				{
					Toast.makeText(getActivity(), "Failure", Toast.LENGTH_LONG).show();

				}
			});
		}
	}*/

	/*public static class ListFragment extends Fragment
	{

		private RestClient restClient;
		private List<Forecast> forecastList;
		private ForecastAdapter recAdapter;
		private RecyclerView recList;
		public ListFragment()
		{
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
								 Bundle savedInstanceState)
		{
			View rootView = inflater.inflate(R.layout.view_hourlist, container, false);
			recList = (RecyclerView) rootView.findViewById(R.id.hourlyList);
			recList.setHasFixedSize(true);
			LinearLayoutManager llm = new LinearLayoutManager(getActivity());
			llm.setOrientation(LinearLayoutManager.VERTICAL);
			recList.setLayoutManager(llm);
			return rootView;
		}

		@Override
		public void onResume()
		{
			super.onResume();
		 	restClient = new RestClient();

					restClient.getApiService().getHourlyCondition("zmw:94101.1.99999", new Callback<Forecasts>()
					{
						@Override
						public void success(Forecasts forecasts, Response response)
						{
							forecastList = forecasts.getForecastList();
							recList.setAdapter(new ForecastAdapter(forecastList));
						}

						@Override
						public void failure(RetrofitError error)
						{

						}
					
				

			});
		}

	}*/
}

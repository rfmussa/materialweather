package renato.weather.carrot.com.carrot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.List;

import renato.weather.carrot.com.carrot.events.EventBus;
import renato.weather.carrot.com.carrot.events.LocationChangeEvent;
import renato.weather.carrot.com.carrot.rest.RestClient;
import renato.weather.carrot.com.carrot.rest.model.Forecast;
import renato.weather.carrot.com.carrot.rest.model.Forecasts;
import renato.weather.carrot.com.carrot.rest.model.Location;
import renato.weather.carrot.com.carrot.rest.model.ObservationResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Renato on 08/01/15.
 */
public class MainFragment extends Fragment
{
	private TextView locationName;
	private TextView condition;
	private TextView temperature;
	private TextView wind;
	private TextView precipitation;

	private WeatherImageView conditionImage;
	private ImageView windImage;
	private ImageView precipitationImage;

	private RestClient restClient;

	private List<Forecast> forecastList;
	private ForecastAdapter recAdapter;
	private RecyclerView recList;

	public MainFragment()
	{

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		locationName = (TextView) rootView.findViewById(R.id.location_name);
		condition = (TextView) rootView.findViewById(R.id.condition_text);
		temperature = (TextView) rootView.findViewById(R.id.temperature);
		wind = (TextView) rootView.findViewById(R.id.wind_text);
		precipitation = (TextView) rootView.findViewById(R.id.precipitation_text);
		conditionImage = (WeatherImageView) rootView.findViewById(R.id.condition_image);

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
		
		EventBus.getInstance().register(this);

		restClient = RestClient.getInstance();
		if (forecastList == null)
		{
			restClient.getApiService().getCondition("94101.1.99999", new Callback<ObservationResponse>()
			{
				@Override
				public void success(ObservationResponse data, Response response)
				{
					condition.setText(data.getCurrentObservation().getWeather());
					wind.setText(data.getCurrentObservation().getWindGustKph());
					precipitation.setText(data.getCurrentObservation().getRelativeHumidity());
					temperature.setText(data.getCurrentObservation().getTempC() + " \u2103");
					conditionImage.setCondition(data.getCurrentObservation().getIcon());

							restClient.getApiService().getHourlyCondition("94101.1.99999", new Callback<Forecasts>()
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

				@Override
				public void failure(RetrofitError error)
				{
					Toast.makeText(getActivity(), "Failure", Toast.LENGTH_LONG).show();

				}
			});
		}
	}

	@Override
	public void onPause()
	{
		super.onPause();
		EventBus.getInstance().unregister(this);
	}

	private void getConditions(final Location location)
	{
		restClient = RestClient.getInstance();

			restClient.getApiService().getCondition(location.getCode(), new Callback<ObservationResponse>()
			{
				@Override
				public void success(ObservationResponse data, Response response)
				{
					condition.setText(data.getCurrentObservation().getWeather());
					wind.setText(data.getCurrentObservation().getWindGustKph());
					precipitation.setText(data.getCurrentObservation().getRelativeHumidity());
					temperature.setText(data.getCurrentObservation().getTempC() + " \u2103");
					conditionImage.setCondition(data.getCurrentObservation().getIcon());
					restClient.getApiService().getHourlyCondition(location.getLink(), new Callback<Forecasts>()
					{
						@Override
						public void success(Forecasts forecasts, Response response)
						{
							restClient.getApiService().getHourlyCondition(location.getCode(), new Callback<Forecasts>()
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
	
	@Subscribe
	public void locationChanged(LocationChangeEvent event) {
		Location location = event.location;
		locationName.setText(location.getName());
		getConditions(location);
	}

}

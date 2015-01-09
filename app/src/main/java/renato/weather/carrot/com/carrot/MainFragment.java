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

import java.util.List;

import renato.weather.carrot.com.carrot.rest.RestClient;
import renato.weather.carrot.com.carrot.rest.model.Forecast;
import renato.weather.carrot.com.carrot.rest.model.Forecasts;
import renato.weather.carrot.com.carrot.rest.model.ObservationResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Renato on 08/01/15.
 */
public class MainFragment extends Fragment
{
	private TextView location_name;
	private TextView condition_text;
	private TextView temperature;
	private TextView wind_text;
	private TextView precipitation_text;

	private WeatherImageView condition_image;
	private ImageView wind_image;
	private ImageView precipitation_image;

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

		location_name = (TextView) rootView.findViewById(R.id.location_name);
		condition_text = (TextView) rootView.findViewById(R.id.condition_text);
		temperature = (TextView) rootView.findViewById(R.id.temperature);
		wind_text = (TextView) rootView.findViewById(R.id.wind_text);
		precipitation_text = (TextView) rootView.findViewById(R.id.precipitation_text);
		condition_image = (WeatherImageView) rootView.findViewById(R.id.condition_image);

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

		restClient = RestClient.getInstance();
		restClient.getApiService().getCondition("zmw:94101.1.99999", new Callback<ObservationResponse>()
		{
			@Override
			public void success(ObservationResponse data, Response response)
			{
				condition_text.setText(data.getCurrentObservation().getWeather());
				wind_text.setText(data.getCurrentObservation().getWindGustKph());
				precipitation_text.setText(data.getCurrentObservation().getRelativeHumidity());
				temperature.setText(data.getCurrentObservation().getTempC() + " \u2103");
				condition_image.setCondition(data.getCurrentObservation().getIcon());
				restClient.getApiService().getHourlyCondition("zmw:94101.1.99999", new Callback<Forecasts>()
				{
					@Override
					public void success(Forecasts forecasts, Response response)
					{
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

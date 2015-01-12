package renato.weather.carrot.com.carrot.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Renato on 04/01/15.
 */
public class Forecasts
{
	@SerializedName("hourly_forecast")
	public List<Forecast> forecastList;

	public List<Forecast> getForecastList()
	{
		return forecastList;
	}
}

package renato.weather.carrot.com.carrot.rest.service;

import renato.weather.carrot.com.carrot.rest.model.Forecasts;
import renato.weather.carrot.com.carrot.rest.model.ObservationResponse;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Renato on 04/01/15.
 */
public interface WundergroundService
{

	@GET("/conditions/q/{l}.{output}")
	void getCondition(@Path("l") String link, Callback<ObservationResponse> callback);

	@GET("/hourly/q/{l}.{output}")
	void getHourlyCondition(@Path("l") String link, Callback<Forecasts> callback);
}

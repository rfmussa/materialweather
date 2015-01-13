package renato.weather.carrot.com.carrot.rest.service;

import renato.weather.carrot.com.carrot.rest.model.Forecasts;
import renato.weather.carrot.com.carrot.rest.model.ObservationResponse;
import retrofit.Callback;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Renato on 04/01/15.
 */
public interface WundergroundService
{
	@GET("/conditions/q/zmw:{l}.{output}")
	void getCondition(@Path(value = "l", encode = false) String link, Callback<ObservationResponse> callback);

	@GET("/hourly/q/zmw:{l}.{output}")
	void getHourlyCondition(@Path(value = "l", encode = false) String link, Callback<Forecasts> callback);
}

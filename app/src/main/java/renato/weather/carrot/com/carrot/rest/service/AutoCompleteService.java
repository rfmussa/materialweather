package renato.weather.carrot.com.carrot.rest.service;

import renato.weather.carrot.com.carrot.rest.model.Results;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Renato on 04/01/15.
 */
public interface AutoCompleteService
{
	@GET("/aq")
	void getLocations(@Query("query") String query, Callback<Results> callback);
}

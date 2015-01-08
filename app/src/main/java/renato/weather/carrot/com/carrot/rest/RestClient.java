package renato.weather.carrot.com.carrot.rest;

import renato.weather.carrot.com.carrot.rest.service.AutoCompleteService;
import renato.weather.carrot.com.carrot.rest.service.WundergroundService;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by Renato on 03/01/15.
 */
public class RestClient
{
	private static final String OUTPUT_FORMAT = "json";
	private static final String BASE_URL = "http://api.wunderground.com/api/659238e4cd7d1530";
	private static final String SEARCH_URL = "http://autocomplete.wunderground.com/";

	private WundergroundService wundergroundService;
	private AutoCompleteService autoCompleteService;


	public RestClient()
	{
		/*Gson gson = new GsonBuilder()
				.setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
				.create();*/

		RequestInterceptor requestInterceptor = new RequestInterceptor()
		{
			@Override
			public void intercept(RequestFacade request)
			{
				request.addPathParam("output", OUTPUT_FORMAT);
			}
		};

		RestAdapter restAdapter = new RestAdapter.Builder()
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.setEndpoint(BASE_URL)
				.setRequestInterceptor(requestInterceptor)
						//.setConverter(new GsonConverter(gson))
				.build();

		wundergroundService = restAdapter.create(WundergroundService.class);

		RestAdapter autoCompleteAdapter = new RestAdapter.Builder()
				.setEndpoint(SEARCH_URL)
				.setLogLevel(RestAdapter.LogLevel.FULL)
				.build();

		autoCompleteService = autoCompleteAdapter.create(AutoCompleteService.class);

	}

	public WundergroundService getApiService()
	{
		return wundergroundService;
	}

	public AutoCompleteService getAutoCompleteService()
	{
		return autoCompleteService;
	}

}

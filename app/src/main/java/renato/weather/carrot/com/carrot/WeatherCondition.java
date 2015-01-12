package renato.weather.carrot.com.carrot;

import java.util.HashMap;

/**
 * Created by Renato on 07/01/15.
 */
public class WeatherCondition
{

	private HashMap<String, String> conditionHashmap;

	public WeatherCondition()
	{
		conditionHashmap = new HashMap<>();
		conditionHashmap.put("chanceflurries", "meteo-snowy1");
		conditionHashmap.put("chancerain", "meteo-rainy1");
		conditionHashmap.put("chancesleet", "meteo-snowflake");
		conditionHashmap.put("chancesnow", "meteo-snowy1");
		conditionHashmap.put("chancestorms", "meteo-lighting1");

		conditionHashmap.put("clear", "meteo-sun");
		conditionHashmap.put("cloudy", "meteo-cloudy4");
		conditionHashmap.put("flurries", "meteo-snowy1");
		conditionHashmap.put("fog", "meteo-lines");
		conditionHashmap.put("hazy", "meteo-none");

		conditionHashmap.put("mostlycloudy", "meteo-cloudy3");
		conditionHashmap.put("mostlysunny", "meteo-sunny3");
		conditionHashmap.put("partlycloudy", "meteo-cloudy2");
		conditionHashmap.put("partlysunny", "meteo-sunny2");

		conditionHashmap.put("sleet", "meteo-snowflake");
		conditionHashmap.put("rain", "meteo-rainy4");
		conditionHashmap.put("snow", "meteo-snowy4");
		conditionHashmap.put("sunny", "meteo-sunny4");
		conditionHashmap.put("tstorms", "meteo-lightning4");
		conditionHashmap.put("unknown", "meteo-none");
	}

	public HashMap<String, String> getConditionHashmap()
	{
		return conditionHashmap;
	}
}

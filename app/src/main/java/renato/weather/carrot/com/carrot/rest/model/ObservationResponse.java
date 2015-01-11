package renato.weather.carrot.com.carrot.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Renato on 04/01/15.
 */
public class ObservationResponse
{
	@SerializedName("current_observation")
	public Current_Observation currentObservation;

	@SerializedName("display_location")
	public DisplayLocation displayLocation;

	public Current_Observation getCurrentObservation()
	{
		return currentObservation;
	}

	public DisplayLocation getDisplayLocation()
	{
		return displayLocation;
	}

	public class Current_Observation
	{
		@SerializedName("station_id")

		private String stationId;

		@SerializedName("observation_time")
		private String observationTime;

		@SerializedName("observation_time_rfc822")
		private String observationTimeRfc822;

		@SerializedName("observation_epoch")
		private String observationEpoch;

		@SerializedName("local_time_rfc822")
		private String localTimeRfc822;

		@SerializedName("local_epoch")
		private String localEpoch;

		@SerializedName("local_tz_short")
		private String localTzShort;

		@SerializedName("local_tz_long")
		private String localTzLong;

		@SerializedName("local_tz_offset")
		private String localTzOffset;

		private String weather;

		@SerializedName("temperature_string")
		private String temperatureString;

		@SerializedName("temp_f")
		private Double tempF;

		@SerializedName("temp_c")
		private Double tempC;

		@SerializedName("relative_humidity")
		private String relativeHumidity;

		@SerializedName("wind_string")
		private String windString;

		@SerializedName("wind_dir")
		private String windDir;

		@SerializedName("wind_degrees")
		private Integer windDegrees;

		@SerializedName("wind_mph")
		private Double windMph;

		@SerializedName("wind_gust_mph")
		private String windGustMph;

		@SerializedName("wind_kph")
		private Double windKph;

		@SerializedName("wind_gust_kph")
		private String windGustKph;

		@SerializedName("pressure_mb")
		private String pressureMb;

		@SerializedName("pressure_in")
		private String pressureIn;

		@SerializedName("pressure_trend")
		private String pressureTrend;

		@SerializedName("dewpoint_string")
		private String dewpointString;

		@SerializedName("dewpoint_f")
		private Integer dewpointF;

		@SerializedName("dewpoint_c")
		private Integer dewpointC;

		@SerializedName("heat_index_string")
		private String heatIndexString;

		@SerializedName("heat_index_f")
		private String heatIndexF;

		@SerializedName("heat_index_c")
		private String heatIndexC;

		@SerializedName("windchill_string")
		private String windchillString;

		@SerializedName("windchill_f")
		private String windchillF;

		@SerializedName("windchill_c")
		private String windchillC;
		@SerializedName("feelslike_string")

		private String feelslikeString;
		@SerializedName("feelslike_f")

		private String feelslikeF;
		@SerializedName("feelslike_c")

		private String feelslikeC;
		@SerializedName("visibility_mi")

		private String visibilityMi;
		@SerializedName("visibility_km")

		private String visibilityKm;

		private String solarradiation;

		private String UV;

		@SerializedName("precip_1hr_string")
		private String precip1hrString;

		@SerializedName("precip_1hr_in")

		private String precip1hrIn;
		@SerializedName("precip_1hr_metric")

		private String precip1hrMetric;
		@SerializedName("precip_today_string")

		private String precipTodayString;
		@SerializedName("precip_today_in")

		private String precipTodayIn;
		@SerializedName("precip_today_metric")

		private String precipTodayMetric;

		private String icon;

		@SerializedName("icon_url")
		private String iconUrl;

		@SerializedName("forecast_url")

		private String forecastUrl;
		@SerializedName("history_url")

		private String historyUrl;
		@SerializedName("ob_url")

		private String obUrl;

		public String getStationId()
		{
			return stationId;
		}

		public String getObservationTime()
		{
			return observationTime;
		}

		public String getObservationTimeRfc822()
		{
			return observationTimeRfc822;
		}

		public String getObservationEpoch()
		{
			return observationEpoch;
		}

		public String getLocalTimeRfc822()
		{
			return localTimeRfc822;
		}

		public String getLocalEpoch()
		{
			return localEpoch;
		}

		public String getLocalTzShort()
		{
			return localTzShort;
		}

		public String getLocalTzLong()
		{
			return localTzLong;
		}

		public String getLocalTzOffset()
		{
			return localTzOffset;
		}

		public String getWeather()
		{
			return weather;
		}

		public String getTemperatureString()
		{
			return temperatureString;
		}

		public Double getTempF()
		{
			return tempF;
		}

		public Double getTempC()
		{
			return tempC;
		}

		public String getRelativeHumidity()
		{
			return relativeHumidity;
		}

		public String getWindString()
		{
			return windString;
		}

		public String getWindDir()
		{
			return windDir;
		}

		public Integer getWindDegrees()
		{
			return windDegrees;
		}

		public Double getWindMph()
		{
			return windMph;
		}

		public String getWindGustMph()
		{
			return windGustMph;
		}

		public Double getWindKph()
		{
			return windKph;
		}

		public String getWindGustKph()
		{
			return windGustKph;
		}

		public String getPressureMb()
		{
			return pressureMb;
		}

		public String getPressureIn()
		{
			return pressureIn;
		}

		public String getPressureTrend()
		{
			return pressureTrend;
		}

		public String getDewpointString()
		{
			return dewpointString;
		}

		public Integer getDewpointF()
		{
			return dewpointF;
		}

		public Integer getDewpointC()
		{
			return dewpointC;
		}

		public String getHeatIndexString()
		{
			return heatIndexString;
		}

		public String getHeatIndexF()
		{
			return heatIndexF;
		}

		public String getHeatIndexC()
		{
			return heatIndexC;
		}

		public String getWindchillString()
		{
			return windchillString;
		}

		public String getWindchillF()
		{
			return windchillF;
		}

		public String getWindchillC()
		{
			return windchillC;
		}

		public String getFeelslikeString()
		{
			return feelslikeString;
		}

		public String getFeelslikeF()
		{
			return feelslikeF;
		}

		public String getFeelslikeC()
		{
			return feelslikeC;
		}

		public String getVisibilityMi()
		{
			return visibilityMi;
		}

		public String getVisibilityKm()
		{
			return visibilityKm;
		}

		public String getSolarradiation()
		{
			return solarradiation;
		}

		public String getUV()
		{
			return UV;
		}

		public String getPrecip1hrString()
		{
			return precip1hrString;
		}

		public String getPrecip1hrIn()
		{
			return precip1hrIn;
		}

		public String getPrecip1hrMetric()
		{
			return precip1hrMetric;
		}

		public String getPrecipTodayString()
		{
			return precipTodayString;
		}

		public String getPrecipTodayIn()
		{
			return precipTodayIn;
		}

		public String getPrecipTodayMetric()
		{
			return precipTodayMetric;
		}

		public String getIcon()
		{
			return icon;
		}

		public String getIconUrl()
		{
			return iconUrl;
		}

		public String getForecastUrl()
		{
			return forecastUrl;
		}

		public String getHistoryUrl()
		{
			return historyUrl;
		}

		public String getObUrl()
		{
			return obUrl;
		}
	}

	public class DisplayLocation
	{
		private String full;
		private String city;
		private String state;

		@SerializedName("state_name")
		private String stateName;

		private String country;

		@SerializedName("country_iso3166")
		private String countryIso3166;

		private String zip;
		private String latitude;
		private String longitude;
		private String elevation;

		public String getElevation()
		{
			return elevation;
		}

		public String getCity()
		{
			return city;
		}

		public String getState()
		{
			return state;
		}

		public String getStateName()
		{
			return stateName;
		}

		public String getCountry()
		{
			return country;
		}

		public String getCountryIso3166()
		{
			return countryIso3166;
		}

		public String getZip()
		{
			return zip;
		}

		public String getLatitude()
		{
			return latitude;
		}

		public String getLongitude()
		{
			return longitude;
		}

		public String getFull()
		{
			return full;
		}
	}
}

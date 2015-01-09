package renato.weather.carrot.com.carrot.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Renato on 04/01/15.
 */
public class Forecast
{
	@SerializedName("FCTTIME")
	public FCTTIME time;

	@SerializedName("temp")
	private Temperature temperature;

	private DewPoint dewpoint;

	private String condition;

	private String icon;
	@SerializedName("icon_url")

	private String iconUrl;

	@SerializedName("fctcode")
	private String fctCode;

	private String sky;

	@SerializedName("wspd")
	private WindSpeed windSpeed;

	@SerializedName("wdir")
	private WindDirection windDirection;

	private String wx;

	private String uvi;

	private String humidity;

	private Windchill windchill;

	private Heatindex heatindex;

	private Feelslike feelslike;
	
	@SerializedName("pop")
	private String precipitationChance;

	public FCTTIME getTime()
	{
		return time;
	}

	public Temperature getTemperature()
	{
		return temperature;
	}

	public DewPoint getDewpoint()
	{
		return dewpoint;
	}

	public String getCondition()
	{
		return condition;
	}

	public String getIcon()
	{
		return icon;
	}

	public String getIconUrl()
	{
		return iconUrl;
	}

	public String getFctCode()
	{
		return fctCode;
	}

	public String getSky()
	{
		return sky;
	}

	public WindSpeed getWindSpeed()
	{
		return windSpeed;
	}

	public WindDirection getWindDirection()
	{
		return windDirection;
	}

	public String getWx()
	{
		return wx;
	}

	public String getUvi()
	{
		return uvi;
	}

	public String getHumidity()
	{
		return humidity;
	}

	public Windchill getWindchill()
	{
		return windchill;
	}

	public Heatindex getHeatindex()
	{
		return heatindex;
	}

	public Feelslike getFeelslike()
	{
		return feelslike;
	}

	public String getPrecipitationChance()
	{
		return precipitationChance;
	}

	public class FCTTIME
	{

		private String hour;

		@SerializedName("hour_padded")
		private String hourPadded;

		private String min;
		private String sec;
		private String year;
		private String mon;

		@SerializedName("mon_padded")
		private String monthPadded;

		@SerializedName("mon_abbrev")
		private String month;

		@SerializedName("mDay")
		private String day;

		@SerializedName("mday_padded")
		private String dayPadded;

		@SerializedName("yDay")
		private String yearDay;
		
		private String isdst;
		private String epoch;
		private String pretty;
		private String civil;

		@SerializedName("month_name")
		private String monthName;

		@SerializedName("month_name_abbrev")
		private String monthNameAbbrev;

		@SerializedName("weekday_name")
		private String weekdayName;

		@SerializedName("weekday_name_night")
		private String weekdayNameNight;

		@SerializedName("weekday_name_abbrev")
		private String weekdayNameAbbrev;

		private String ampm;
		private String tz;
		private String age;

		public String getHour()
		{
			return hour;
		}

		public String getHourPadded()
		{
			return hourPadded;
		}

		public String getMin()
		{
			return min;
		}

		public String getSec()
		{
			return sec;
		}

		public String getYear()
		{
			return year;
		}

		public String getMon()
		{
			return mon;
		}

		public String getMonthPadded()
		{
			return monthPadded;
		}

		public String getMonth()
		{
			return month;
		}

		public String getDay()
		{
			return day;
		}

		public String getDayPadded()
		{
			return dayPadded;
		}

		public String getYearDay()
		{
			return yearDay;
		}

		public String getIsdst()
		{
			return isdst;
		}

		public String getEpoch()
		{
			return epoch;
		}

		public String getPretty()
		{
			return pretty;
		}

		public String getCivil()
		{
			return civil;
		}

		public String getMonthName()
		{
			return monthName;
		}

		public String getMonthNameAbbrev()
		{
			return monthNameAbbrev;
		}

		public String getWeekdayName()
		{
			return weekdayName;
		}

		public String getWeekdayNameNight()
		{
			return weekdayNameNight;
		}

		public String getWeekdayNameAbbrev()
		{
			return weekdayNameAbbrev;
		}

		public String getAmpm()
		{
			return ampm;
		}

		public String getTz()
		{
			return tz;
		}

		public String getAge()
		{
			return age;
		}
	}


}

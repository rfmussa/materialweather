package renato.weather.carrot.com.carrot.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Renato on 04/01/15.
 */
public class Forecast
{
	@SerializedName("FCTTIME")
	public FCTTIME time;

	private Temperature temp;

	private DewPoint dewpoint;

	private String condition;

	private String icon;
	@SerializedName("icon_url")

	private String iconUrl;

	private String fctcode;

	private String sky;

	private WindSpeed wspd;

	private WindDirection wdir;

	private String wx;

	private String uvi;

	private String humidity;

	private Windchill windchill;

	private Heatindex heatindex;

	private Feelslike feelslike;


	private String pop;

	public FCTTIME getTime()
	{
		return time;
	}

	public Temperature getTemp()
	{
		return temp;
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

	public String getFctcode()
	{
		return fctcode;
	}

	public String getSky()
	{
		return sky;
	}

	public WindSpeed getWspd()
	{
		return wspd;
	}

	public WindDirection getWdir()
	{
		return wdir;
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

	public String getPop()
	{
		return pop;
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
		private String monPadded;

		@SerializedName("mon_abbrev")
		private String monAbbrev;

		private String mday;

		@SerializedName("mday_padded")
		private String mdayPadded;

		private String yday;
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

		@SerializedName("weekday_name_unlang")
		private String weekdayNameUnlang;

		@SerializedName("weekday_name_night_unlang")
		private String weekdayNameNightUnlang;

		private String ampm;
		private String tz;
		private String age;

		public String getAge()
		{
			return age;
		}

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

		public String getMonPadded()
		{
			return monPadded;
		}

		public String getMonAbbrev()
		{
			return monAbbrev;
		}

		public String getMday()
		{
			return mday;
		}

		public String getMdayPadded()
		{
			return mdayPadded;
		}

		public String getYday()
		{
			return yday;
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

		public String getWeekdayNameUnlang()
		{
			return weekdayNameUnlang;
		}

		public String getWeekdayNameNightUnlang()
		{
			return weekdayNameNightUnlang;
		}

		public String getAmpm()
		{
			return ampm;
		}

		public String getTz()
		{
			return tz;
		}
	}


}

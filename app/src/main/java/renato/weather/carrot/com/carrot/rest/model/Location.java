package renato.weather.carrot.com.carrot.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Renato on 04/01/15.
 */
public class Location
{
	private String name;
	private String type;

	@SerializedName("c")
	private String country;

	private String zmw;

	private String tz;

	private String tzs;

	@SerializedName("l")
	private String link;

	private String lat;

	private String lon;

	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type;
	}

	public String getCountry()
	{
		return country;
	}

	public String getZmw()
	{
		return zmw;
	}

	public String getTz()
	{
		return tz;
	}

	public String getTzs()
	{
		return tzs;
	}

	public String getLink()
	{
		return link;
	}

	public String getLat()
	{
		return lat;
	}

	public String getLon()
	{
		return lon;
	}
}

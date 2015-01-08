package renato.weather.carrot.com.carrot.rest.model;

/**
 * Created by Renato on 04/01/15.
 */
public class Result
{
	private String name;

	private String type;

	private String c;

	private String zmw;

	private String tz;

	private String tzs;

	private String l;

	private String lat;

	private String lon;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getC()
	{
		return c;
	}

	public void setC(String c)
	{
		this.c = c;
	}

	public String getZmw()
	{
		return zmw;
	}

	public void setZmw(String zmw)
	{
		this.zmw = zmw;
	}

	public String getTz()
	{
		return tz;
	}

	public void setTz(String tz)
	{
		this.tz = tz;
	}

	public String getTzs()
	{
		return tzs;
	}

	public void setTzs(String tzs)
	{
		this.tzs = tzs;
	}

	public String getL()
	{
		return l;
	}

	public void setL(String l)
	{
		this.l = l;
	}

	public String getLat()
	{
		return lat;
	}

	public void setLat(String lat)
	{
		this.lat = lat;
	}

	public String getLon()
	{
		return lon;
	}

	public void setLon(String lon)
	{
		this.lon = lon;
	}
}

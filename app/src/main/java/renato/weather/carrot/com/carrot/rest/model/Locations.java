package renato.weather.carrot.com.carrot.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Renato on 04/01/15.
 */
public class Locations
{
	@SerializedName("RESULTS")
	private List<Location> locationsList;

	public List<Location> getLocationsList()
	{
		return locationsList;
	}
}

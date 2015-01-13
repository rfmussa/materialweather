package renato.weather.carrot.com.carrot.events;

import renato.weather.carrot.com.carrot.rest.model.Location;

/**
 * Created by Renato on 12/01/15.
 */
public class LocationChangeEvent
{
	public final Location location;
	
	public LocationChangeEvent(Location location)
	{
		this.location = location;
	}
}

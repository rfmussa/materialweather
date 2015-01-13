package renato.weather.carrot.com.carrot;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import renato.weather.carrot.com.carrot.rest.model.Location;
import renato.weather.carrot.com.carrot.rest.model.Locations;

/**
 * Created by Renato on 13/01/15.
 */
public class LocationManager
{
	private final String LOCATIONS_ID = "LOCATIONS_ID";
	private static LocationManager singleton;
	private SharedPreferences preferences;
	private Context context;
	private Gson gson;
	private SharedPreferences.Editor editor;
	private List<Location> savedLocations;
	
	public static LocationManager getInstance(Context context)
	{
		if (singleton == null)
		{
			singleton = new LocationManager(context);
		}
		return singleton;
	}
	
	public LocationManager(Context context)
	{
		this.context = context;
		gson = new Gson();
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
		editor = preferences.edit();
	}
	
	// serialize
	private void serialize()
	{
		String locationsString = gson.toJson(savedLocations);
		editor.putString(LOCATIONS_ID, locationsString);
		editor.commit();
	}
	public void addLocation(Location location)
	{
		savedLocations.add(location);
		serialize();
		
	}
	
	public void removeLocation(int position)
	{
		savedLocations.remove(position);
		serialize();
	}
	
	
	// deserialize
	public List<Location> getLocations()
	{
		if(savedLocations != null)
		{
			return savedLocations;
		}

		String locationsString = preferences.getString(LOCATIONS_ID, null);
		Type type = new TypeToken< List < Location >>() {}.getType();
		savedLocations = new Gson().fromJson(locationsString, type);
		
		return savedLocations;
	}
}

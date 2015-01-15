package renato.weather.carrot.com.carrot;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import renato.weather.carrot.com.carrot.events.EventBus;
import renato.weather.carrot.com.carrot.events.SavedLocationChange;
import renato.weather.carrot.com.carrot.rest.model.Location;

/**
 * Created by Renato on 13/01/15.
 */
public class LocationManager
{
	private final String LOCATIONS_ID = "LOCATIONS_ID";
	private static LocationManager singleton;
	private SharedPreferences preferences;
	private Gson gson;
	private SharedPreferences.Editor editor;
	private List<Location> savedLocations;
	private Context context;

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
		getLocations();
	}
	
	// update
	private void update()
	{
		String locationsString = gson.toJson(savedLocations);
		editor.putString(LOCATIONS_ID, locationsString);
		editor.apply();
		EventBus.getInstance().post(new SavedLocationChange());

	}
	public void addLocation(Location location)
	{
		if(savedLocations == null)
		{
			savedLocations = new ArrayList<>();
		}
		savedLocations.add(location);
		update();
		Log.d("Location Added", location.getName());
	}
	
	public void removeLocation(int position)
	{
		if(savedLocations != null)
		{
			String locationName = savedLocations.get(position).getName();
			savedLocations.remove(position);
			update();
			Log.d("Location Removed", locationName);
		}
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

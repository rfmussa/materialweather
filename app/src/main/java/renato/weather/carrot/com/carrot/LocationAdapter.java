package renato.weather.carrot.com.carrot;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import renato.weather.carrot.com.carrot.events.EventBus;
import renato.weather.carrot.com.carrot.events.LocationChangeEvent;
import renato.weather.carrot.com.carrot.rest.model.Location;

/**
 * Created by Renato on 11/01/15.
 */
public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder>
{

	private List<Location> locationList;
	private boolean isFavouriteList;
	private Context context;
	public LocationAdapter(List<Location> locationList, boolean isFavouriteList)
	{
		this.locationList = locationList;
		this.isFavouriteList = isFavouriteList;

	}
	
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		context = parent.getContext();
		View locationItem = LayoutInflater.from(context).inflate(R.layout.view_location_item, parent, false);
		return new ViewHolder(locationItem);
	}
	
	@Override
	public void onBindViewHolder(ViewHolder holder, final int position)
	{
		final Location searchLocation = locationList.get(position);
		
		holder.locationCity.setText(searchLocation.getName());
		holder.locationCity.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EventBus.getInstance().post(new LocationChangeEvent(locationList.get(position)));
			}
		});
		
		holder.addButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(isFavouriteList)
				{
					remove(position);
				}
				else
				{
					add(searchLocation);
				}
			}
		});
		
		holder.setToggleIcon(isFavouriteList);
	}
	
	@Override
	public int getItemCount()
	{
		return locationList.size();
	}
	
	public static class ViewHolder extends RecyclerView.ViewHolder
	{
		private TextView locationCity;
		private Button addButton;
		public ViewHolder(View itemView)
		{
			super(itemView);
			
			locationCity = (TextView) itemView.findViewById(R.id.city_text);
			addButton = (Button) itemView.findViewById(R.id.add_button);
			
		}
		
		public void setToggleIcon(boolean isFavouriteList)
		{
			
			addButton.setBackgroundResource(isFavouriteList ? R.drawable.ic_trash: R.drawable.ic_add);
		}
	}
	
	private void add(Location location)
	{
		LocationManager.getInstance(context).addLocation(location);
	}
	
	private void remove(int position)
	{
		LocationManager.getInstance(context).removeLocation(position);
	}
}

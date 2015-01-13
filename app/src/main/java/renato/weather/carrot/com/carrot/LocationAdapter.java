package renato.weather.carrot.com.carrot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

	public LocationAdapter(List<Location> locationList)
	{
		this.locationList = locationList;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		Context context = parent.getContext();
		View locationItem = LayoutInflater.from(context).inflate(R.layout.view_location_item, parent, false);
		return new ViewHolder(locationItem);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, final int position)
	{
		Location searchLocation = locationList.get(position);
		holder.locationCity.setText(searchLocation.getName());
		
		holder.itemView.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EventBus.getInstance().post(new LocationChangeEvent(locationList.get(position)));
			}
		});
	}

	@Override
	public int getItemCount()
	{
		//TODO replace this value with something more relevant
		return locationList.size();
	}

	public static class ViewHolder extends RecyclerView.ViewHolder
	{
		private TextView locationCity;

		public ViewHolder(View itemView)
		{
			super(itemView);

			locationCity = (TextView) itemView.findViewById(R.id.city_text);

		}

	}
}

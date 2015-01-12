package renato.weather.carrot.com.carrot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import renato.weather.carrot.com.carrot.rest.model.Forecast;

/**
 * Created by Renato on 06/01/15.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder>
{

	private List<Forecast> forecastList;
	private WeatherCondition weatherCondition = new WeatherCondition();

	public ForecastAdapter(List<Forecast> forecastList)
	{
		this.forecastList = forecastList;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		Context context = parent.getContext();
		View hourlyView = LayoutInflater.from(context).inflate(R.layout.view_hourly, parent, false);
		return new ViewHolder(hourlyView);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position)
	{
		final Forecast forecast = forecastList.get(position);

		holder.hourly_image.setCondition(forecast.getIcon());
		holder.temperature.setText(forecast.getTemperature().getMetric() + " \u2103");
		holder.text.setText(forecast.getTime().getCivil());
		holder.condition.setText(forecast.getCondition());

	}

	@Override
	public int getItemCount()
	{
		// only temperatures for the next 24 hours
		return 24;
	}

	public static class ViewHolder extends RecyclerView.ViewHolder
	{
		private WeatherImageView hourly_image;
		private TextView text;
		private TextView condition;
		private TextView temperature;

		public ViewHolder(View itemView)
		{
			super(itemView);

			hourly_image = (WeatherImageView) itemView.findViewById(R.id.hourly_image);
			temperature = (TextView) itemView.findViewById(R.id.hourly_temperature);
			condition = (TextView) itemView.findViewById(R.id.hourly_condition);
			text = (TextView) itemView.findViewById(R.id.hourly_text);
		}

	}
}

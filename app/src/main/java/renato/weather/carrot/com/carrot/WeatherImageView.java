package renato.weather.carrot.com.carrot;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.thedazzler.droidicon.IconicFontDrawable;

/**
 * Created by Renato on 07/01/15.
 */
public class WeatherImageView extends TextView
{
	IconicFontDrawable iconicFontDrawable;
	WeatherCondition weatherCondition;

	public WeatherImageView(Context context)
	{
		super(context);
		init();
	}

	public WeatherImageView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);
		init();
	}

	public WeatherImageView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}


	private void init()
	{
		weatherCondition = new WeatherCondition();
		iconicFontDrawable = new IconicFontDrawable(getContext());
		iconicFontDrawable.setIconColor(Color.BLACK);
	}


	public void setCondition(String condition)
	{
		try
		{
			iconicFontDrawable.setIcon(weatherCondition.getConditionHashmap().get(condition));
			setBackgroundDrawable(iconicFontDrawable);
		} catch (Exception e)
		{
			Log.d("Failed to find an appropriate icon for", condition);
		}
	}
}
	



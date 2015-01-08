package renato.weather.carrot.com.carrot.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Renato on 04/01/15.
 */
public class WindDirection
{
	@SerializedName("dir")
	public String direction;

	public String degrees;
}

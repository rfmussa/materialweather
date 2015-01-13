package renato.weather.carrot.com.carrot.events;


import com.squareup.otto.Bus;

/**
 * Created by Renato on 12/01/15.
 */
public final class EventBus {
	private static final Bus BUS = new Bus();

	public static Bus getInstance() {
		return BUS;
	}

	private EventBus() {
		// No instances.
	}
}

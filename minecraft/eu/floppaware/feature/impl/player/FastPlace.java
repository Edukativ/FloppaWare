package eu.floppaware.feature.impl.player;

import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;

public class FastPlace extends Feature {

	private transient int nativeDelay;

	public FastPlace() {
		super("FastPlace", Category.Player);
	}

	@Override
	public void onEnable() {
		nativeDelay = mc.rightClickDelayTimer;
		super.onEnable();
	}

	@Override
	public void onDisable() {
		mc.rightClickDelayTimer = nativeDelay;
		super.onDisable();
	}

	public void onUpdate(EventUpdate e) {
		mc.rightClickDelayTimer = 0;
	}

}

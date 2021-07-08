package eu.floppaware.feature.impl.misc;

import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.settings.impl.NumberSetting;

public class AntiRain extends Feature {

	
	public AntiRain() {
		super("AntiRain", Category.Misc);

	}

	public void onUpdate(EventUpdate event) {
		if (mc.world.isRaining()) {
			mc.world.setRainStrength(0);
			mc.world.setThunderStrength(0);
		}
	}

	public void onEnable() {
		super.onEnable();
	}

	public void onDisable() {
		super.onDisable();
	}

}

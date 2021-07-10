package eu.floppaware.feature.impl.player;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;

public class NoWeb extends Feature {

	public NoWeb() {
		super("NoWeb", Category.Player);
	}


	@EventTarget
	public void onLocalPlayerUpdate(EventUpdate e) {
		mc.player.isInWeb = false;
	}

}
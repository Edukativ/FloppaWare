package eu.floppaware.feature.impl.movement;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;

public class NoJumpDelay extends Feature {

	public NoJumpDelay() {
		super("NoJumpDelay", Category.Movement);
	}

	@EventTarget
	public void onUpdate(EventUpdate event) {
		mc.player.jumpTicks = 0;
	}

}

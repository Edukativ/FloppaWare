package eu.floppaware.feature.impl.combat;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;

public class PushAttack extends Feature {
	
	public PushAttack() {
        super("PushAttack", Category.Combat);
    }

    @EventTarget
    public void onPreMotion(EventUpdate event) {
        if (mc.player.getCooledAttackStrength(0.0f) == 1.0f && mc.gameSettings.keyBindAttack.pressed) {
            mc.clickMouse();
        }
    }

}

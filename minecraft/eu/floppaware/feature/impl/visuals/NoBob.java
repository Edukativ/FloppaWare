package eu.floppaware.feature.impl.visuals;

import org.lwjgl.input.Keyboard;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;

public class NoBob extends Feature {

    public NoBob() {
        super("NoBob", Category.Visuals);
    }

    @Override
    public void onEnable() {
        mc.gameSettings.viewBobbing = true;
        super.onEnable();
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        boolean old = mc.gameSettings.viewBobbing;
        mc.gameSettings.viewBobbing = false;
        mc.gameSettings.viewBobbing = old;
    }
}

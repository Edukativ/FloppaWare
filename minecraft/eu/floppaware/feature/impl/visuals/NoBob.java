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

    @EventTarget
    public void onUpdate(EventUpdate event) {
    }
}

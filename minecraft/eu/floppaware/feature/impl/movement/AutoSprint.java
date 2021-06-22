package eu.floppaware.feature.impl.movement;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.utils.MoveUtils;

public class AutoSprint extends Feature {

    public AutoSprint() {
        super("autosprint", Category.Movement);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        mc.player.setSprinting(MoveUtils.isMove());
    }

}

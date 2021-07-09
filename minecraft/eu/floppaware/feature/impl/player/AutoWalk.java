package eu.floppaware.feature.impl.player;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import org.lwjgl.input.Keyboard;

public class AutoWalk extends Feature {

    public AutoWalk() {
        super("AutoWalk", Category.Player);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        mc.gameSettings.keyBindForward.pressed = true;
    }

    @Override
    public void onDisable() {
        if (!mc.gameSettings.isKeyDown(mc.gameSettings.keyBindForward))
            mc.gameSettings.keyBindForward.pressed = false;
        super.onDisable();
    }

}

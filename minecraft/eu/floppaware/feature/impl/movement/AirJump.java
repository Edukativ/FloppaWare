package eu.floppaware.feature.impl.movement;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.client.Minecraft;

public class AirJump
        extends Feature {
    public AirJump() {
        super("AirJump", Category.Movement);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        Minecraft.getMinecraft().player.onGround = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Minecraft.getMinecraft().player.onGround = false;
    }
}

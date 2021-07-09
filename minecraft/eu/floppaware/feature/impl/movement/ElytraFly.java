package eu.floppaware.feature.impl.movement;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.client.Minecraft;

public class ElytraFly extends Feature{

    public ElytraFly() {
        super("ElytraFly", Category.Misc);
    }

    @EventTarget
    public void onLocalPlayerUpdate(EventUpdate e) {
        if(!Minecraft.getMinecraft().player.isElytraFlying())return;
        float yaw = Minecraft.getMinecraft().player.rotationYaw;
        float pitch = Minecraft.getMinecraft().player.rotationPitch;
        if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
            Minecraft.getMinecraft().player.motionX -= Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch)) * 0.05;
            Minecraft.getMinecraft().player.motionZ += Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch)) * 0.05;
            Minecraft.getMinecraft().player.motionY += Math.sin(Math.toRadians(pitch)) * 0.05;
        }
        if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())Minecraft.getMinecraft().player.motionY += 0.05;
        if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown())Minecraft.getMinecraft().player.motionY -= 0.05;
    }

}

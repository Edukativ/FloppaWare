package eu.floppaware.utils;

import net.minecraft.client.Minecraft;

public class MoveUtils {

    public static Minecraft mc = Minecraft.getMinecraft();

    public static boolean isMove() {
        if (!mc.player.isSneaking()) {
            return (mc.player.movementInput.moveForward != 0 || mc.player.movementInput.moveStrafe != 0);
        }
        return false;
    }

}

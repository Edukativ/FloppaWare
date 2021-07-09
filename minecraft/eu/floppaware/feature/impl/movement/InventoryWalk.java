package eu.floppaware.feature.impl.movement;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class InventoryWalk
        extends Feature {
    public InventoryWalk() {
        super("GuiWalk", Category.Player);
    }

    @EventTarget
    public void o(EventUpdate e) {
        KeyBinding[] arrkeyBinding = new KeyBinding[6];
        arrkeyBinding[0] = InventoryWalk.mc.gameSettings.keyBindForward;
        arrkeyBinding[1] = InventoryWalk.mc.gameSettings.keyBindBack;
        arrkeyBinding[2] = InventoryWalk.mc.gameSettings.keyBindLeft;
        arrkeyBinding[3] = InventoryWalk.mc.gameSettings.keyBindRight;
        arrkeyBinding[4] = InventoryWalk.mc.gameSettings.keyBindJump;
        arrkeyBinding[5] = InventoryWalk.mc.gameSettings.keyBindSprint;
        KeyBinding[] keys = arrkeyBinding;
        if (InventoryWalk.mc.currentScreen != null) {
            if (!(InventoryWalk.mc.currentScreen instanceof GuiChat)) {
                KeyBinding[] arrayOfKeyBinding = keys;
                int i = keys.length;
                for (int b = 0; b < i; b = (byte)(b + 1)) {
                    KeyBinding bind = arrayOfKeyBinding[b];
                    bind.pressed = Keyboard.isKeyDown(bind.getKeyCode());
                }
            }
        }
    }
}

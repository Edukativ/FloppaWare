package eu.floppaware.feature.impl.hud;

import eu.floppaware.Main;
import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.render.EventRender2D;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

public class Hud extends Feature {

    public Hud() {
        super("Hud", Category.Hud);
        setKey(Keyboard.KEY_R);
    }

    @EventTarget
    public void onRender2D(EventRender2D event) {
        int width = mc.fontRendererObj.getStringWidth(Main.name) + 7;
        int height = mc.fontRendererObj.FONT_HEIGHT;
        mc.fontRendererObj.drawStringWithShadow(Main.name, 2, 2, -16);
        int y = 16;

        for (Feature feature : Main.instance.featureManager.getFeatureList()) {
            if (feature.getState() && !feature.isHidden()) {
                Gui.drawRect(0, y, mc.fontRendererObj.getStringWidth(feature.getLabel()) + 4, y + 9, Integer.MIN_VALUE);
                Gui.drawRect(1, 16, 0, y + 9, -1);
                mc.fontRendererObj.drawStringWithShadow(feature.getLabel(), 2, y + 0.5F, -1);
            }
            y += 9;
        }
    }
}

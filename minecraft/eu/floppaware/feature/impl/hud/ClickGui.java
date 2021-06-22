package eu.floppaware.feature.impl.hud;

import eu.floppaware.Main;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import org.lwjgl.input.Keyboard;

public class ClickGui extends Feature {

    public ClickGui() {
        super("clickgui", Category.Hud);
        setKey(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(Main.instance.clickGui);
        state();
        super.onEnable();
    }
}

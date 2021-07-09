package eu.floppaware.feature.impl.visuals;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;

public class AntiRain
        extends Feature {
    public AntiRain() {
        super("AntiRain", Category.Misc);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        if (AntiRain.mc.world.isRaining()) {
            AntiRain.mc.world.setRainStrength(0.0f);
            AntiRain.mc.world.setThunderStrength(0.0f);
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

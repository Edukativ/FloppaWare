package eu.floppaware.feature.impl.visuals;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.settings.impl.ListSetting;
import eu.floppaware.utils.MoveUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class Bright extends Feature {

	public ListSetting mode;
	
	public Bright() {
		super("Bright+", Category.Visuals);
		mode = new ListSetting("Bright mode", "Gamma", "Gamma", "Potion");
        addSettings(mode);
	}

	public void onUpdate(EventUpdate event) {
        if (getState()) {
            if (mode.activeMode == "Gamma") {
                mc.player.removePotionEffect(Potion.getPotionById(16));
                mc.gameSettings.gammaSetting = 1000.0f;
            }
            if (mode.activeMode == "Potion") {
                mc.player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 817, 1));
                mc.gameSettings.gammaSetting = 0.1f;
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.gameSettings.gammaSetting = 0.1f;
        mc.player.removePotionEffect(Potion.getPotionById(16));
    }

}

package eu.floppaware.feature.impl.player;

import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class NoWeb extends Feature {
	
	public NoWeb() {
		super("NoWeb", Category.Player);
	}

	@Override
	public void onDisable() {
		mc.player.isInWeb = true;

	}
	
	@Override
	public void onEnable() {
		mc.player.isInWeb = false;
	}

}
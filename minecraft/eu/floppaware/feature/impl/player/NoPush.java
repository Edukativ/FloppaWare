package eu.floppaware.feature.impl.player;

import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;

public class NoPush extends Feature {

	public NoPush() {
		super("NoPush", Category.Player);
	}

	@Override
	public void onDisable() {
		mc.player.entityCollisionReduction = 0.0F;
	}

	@Override
	public void onEnable() {
		check();
		{
			mc.player.entityCollisionReduction = 1.0F;
		}
	}

}

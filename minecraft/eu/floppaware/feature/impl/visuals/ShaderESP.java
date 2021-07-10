package eu.floppaware.feature.impl.visuals;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class ShaderESP extends Feature {

	public ShaderESP() {
		super("ShaderESP", Category.Visuals);
	}

	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (mc.entityRenderer == null)
			return;
		for (Entity entity : mc.world.playerEntities) {
			if (entity instanceof EntityPlayer) {
				entity.setGlowing(true);
			}
		}
		super.onEnable();
	}

	@Override
	public void onDisable() {
		for (Entity entity : mc.world.playerEntities) {
			if (entity instanceof EntityPlayer) {
				entity.setGlowing(false);
			}
		}
		super.onDisable();
	}

}

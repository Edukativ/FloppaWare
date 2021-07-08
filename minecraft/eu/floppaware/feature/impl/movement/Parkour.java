package eu.floppaware.feature.impl.movement;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.client.Minecraft;

public class Parkour extends Feature{
	
	public Parkour() {
		super("Parkour", Category.Movement);
	}


	@EventTarget
	public void onLocalPlayerUpdate(EventUpdate e) {
		if (Minecraft.getMinecraft().player.onGround && !Minecraft.getMinecraft().player.isSneaking()
				&& !Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed()
				&& Minecraft.getMinecraft().world
						.getCollisionBoxes(Minecraft.getMinecraft().player, Minecraft.getMinecraft().player
								.getEntityBoundingBox().offset(0, -0.5, 0).expand(-0.001, 0, -0.001))
						.isEmpty()) {
			Minecraft.getMinecraft().player.jump();
		}
	}

}

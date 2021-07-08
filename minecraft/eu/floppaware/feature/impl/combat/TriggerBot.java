package eu.floppaware.feature.impl.combat;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

public class TriggerBot extends Feature {

	public TriggerBot() {
		super("TriggerBot", Category.Combat);
	}

	@EventTarget
	public void onEventUpdate(EventUpdate e) {
		Entity entity = mc.objectMouseOver.entityHit;
		if (entity == null || (double) mc.player.getDistanceToEntity(entity) > 3.5
				|| entity instanceof EntityEnderCrystal || entity.isDead
				|| ((EntityLivingBase) entity).getHealth() <= 0.0f || !(entity instanceof EntityPlayer)) {
			return;
		}
		if (mc.player.getCooledAttackStrength(0.0f) == 1.0f) {
			mc.playerController.attackEntity((EntityPlayer) mc.player, entity);
			mc.player.swingArm(EnumHand.MAIN_HAND);
		}
	}

}

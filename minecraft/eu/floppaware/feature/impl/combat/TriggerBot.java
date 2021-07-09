package eu.floppaware.feature.impl.combat;

import eu.floppaware.Main;
import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.friendsystem.Friend;
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
	public boolean onUpdate(EventUpdate evet) {
		Entity entity = TriggerBot.mc.objectMouseOver.entityHit;
		for (Friend friend : Main.instance.friendManager.getFriends()) {
			if (mc.player.getName() == friend.getName()) {
				return false;
			}
		}
		if (entity == null || (double) TriggerBot.mc.player.getDistanceToEntity(entity) > 3.5 || entity instanceof EntityEnderCrystal || entity.isDead || ((EntityLivingBase) entity).getHealth() <= 0.0f || !(entity instanceof EntityPlayer)) {
			return false;
		}
		if (TriggerBot.mc.player.getCooledAttackStrength(0.0f) == 1.0f) {
			TriggerBot.mc.playerController.attackEntity(TriggerBot.mc.player, entity);
			TriggerBot.mc.player.swingArm(EnumHand.MAIN_HAND);
		}
		return false;
	}

}

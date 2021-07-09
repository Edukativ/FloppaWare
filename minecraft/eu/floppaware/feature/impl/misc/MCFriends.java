package eu.floppaware.feature.impl.misc;

import eu.floppaware.Main;
import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.friendsystem.Friend;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import org.lwjgl.input.Mouse;

public class MCFriends extends Feature {
    public boolean onFriend = true;

    public MCFriends() {
        super("MCFriends", Category.Misc);
    }

    @Override
    public void onDisable() {
        this.onFriend = true;
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (Mouse.isButtonDown(2)) {
            if (mc.pointedEntity != null) {
                if (mc.pointedEntity instanceof EntityLivingBase && this.onFriend) {
                    this.onFriend = false;
                    if (Main.instance.friendManager.getFriends().stream().anyMatch(paramFriend -> paramFriend.getName().equals(mc.pointedEntity.getName()))) {
                        Main.instance.friendManager.getFriends().remove(Main.instance.friendManager.getFriend(mc.pointedEntity.getName()));
                        mc.player.playSound(SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF, 1F, 1F);
                    } else {
                        Main.instance.friendManager.addFriend(new Friend("", mc.pointedEntity.getName(), false));
                        mc.player.playSound(SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, 1F, 1F);
                    }
                }
            }
        }
        if (!Mouse.isButtonDown(2)) {
            this.onFriend = true;
        }
    }
}
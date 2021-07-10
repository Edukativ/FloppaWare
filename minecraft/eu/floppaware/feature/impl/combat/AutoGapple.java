package eu.floppaware.feature.impl.combat;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.settings.impl.NumberSetting;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;

public class AutoGapple extends Feature {
    private boolean eating = false;
    private final NumberSetting health;

    public AutoGapple() {
        super("AutoGapple", Category.Combat);
        health = new NumberSetting("Health", 1, 1, 20, 0.1f);
        addSettings(health);

    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        if ((double)(mc.player.getHealth() + mc.player.getAbsorptionAmount()) > this.health.getCurrentValue() && this.eating) {
            this.eating = false;
            this.stop();
            return;
        }
        if (!this.canEat()) {
            return;
        }
        if (this.isFood(mc.player.getHeldItemOffhand())) {
            if ((double)mc.player.getHealth() <= this.health.getCurrentValue() && this.canEat()) {
                KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
                this.eating = true;
            }
        }
        if (!this.canEat()) {
            this.stop();
        }
    }

    public static boolean isNullOrEmptyStack(ItemStack itemStack) {
        return itemStack == null || itemStack.func_190926_b();
    }

    boolean isFood(ItemStack itemStack) {
        return !AutoGapple.isNullOrEmptyStack(itemStack) && itemStack.getItem() instanceof ItemAppleGold;
    }

    public boolean canEat() {
        return AutoGapple.mc.objectMouseOver == null || !(AutoGapple.mc.objectMouseOver.entityHit instanceof EntityVillager);
    }

    void stop() {
        KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
    }

}

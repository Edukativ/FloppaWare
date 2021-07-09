//package eu.floppaware.feature.impl.combat;
//
//import eu.floppaware.Main;
//import eu.floppaware.event.EventTarget;
//import eu.floppaware.event.events.impl.player.EventUpdate;
//import eu.floppaware.feature.Feature;
//import net.minecraft.client.settings.KeyBinding;
//import net.minecraft.entity.passive.EntityVillager;
//import net.minecraft.item.ItemAppleGold;
//import net.minecraft.item.ItemStack;
//
//public class AutoGapple extends Feature {
//    private boolean eating = false;
//    Setting health = new Setting("Health", this, 15.0, 1.0, 20.0, false);
//
//    public AutoGapple() {
//        super("AutoGapple", Category.Combat);
//        Main.instance.setmgr.rSetting(this.health);
//    }
//
//    @EventTarget
//    public void onUpdate(EventUpdate e) {
//        if ((double)(mc.player.getHealth() + Minecraft.player.getAbsorptionAmount()) > this.health.getCurrentValue() && this.eating) {
//            this.eating = false;
//            this.stop();
//            return;
//        }
//        if (!this.canEat()) {
//            return;
//        }
//        if (this.isFood(mc.player.getHeldItemOffhand())) {
//            if ((double)mc.player.getHealth() <= this.health.getValDouble() && this.canEat()) {
//                KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), true);
//                this.eating = true;
//            }
//        }
//        if (!this.canEat()) {
//            this.stop();
//        }
//    }
//
//    public static boolean isNullOrEmptyStack(ItemStack itemStack) {
//        return itemStack == null || itemStack.func_190926_b();
//    }
//
//    boolean isFood(ItemStack itemStack) {
//        return !AutoGapple.isNullOrEmptyStack(itemStack) && itemStack.getItem() instanceof ItemAppleGold;
//    }
//
//    public boolean canEat() {
//        return AutoGapple.mc.objectMouseOver == null || !(AutoGapple.mc.objectMouseOver.entityHit instanceof EntityVillager);
//    }
//
//    void stop() {
//        KeyBinding.setKeyBindState(AutoGapple.mc.gameSettings.keyBindUseItem.getKeyCode(), false);
//    }
//
//}

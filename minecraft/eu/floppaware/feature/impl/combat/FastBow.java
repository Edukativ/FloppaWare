package eu.floppaware.feature.impl.combat;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBow;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.math.BlockPos;

public class FastBow
        extends Feature {
    public FastBow() {
        super("FastBow", Category.Combat);
    }

    @EventTarget
    public void onEventUpdate(EventUpdate e) {
        if (Minecraft.getMinecraft().player.inventory.getCurrentItem().getItem() instanceof ItemBow) {
            if (mc.player.isHandActive()) {
                if ((double)mc.player.getItemInUseMaxCount() >= 2.4) {
                    mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, mc.player.getHorizontalFacing()));
                    mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(mc.player.getActiveHand()));
                    mc.player.stopActiveHand();
                }
            }
        }
    }
}

package eu.floppaware.feature.impl.movement;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.packet.EventSendPacket;
import eu.floppaware.event.events.impl.player.EventUpdate;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;

public class LongJump
        extends Feature {
    int air;

    public LongJump() {
        super("LongJump", Category.Movement);
    }

    @EventTarget
    public void onSendPacket(EventSendPacket event) {
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (!mc.player.onGround) {
            ++this.air;
        } else if (this.air > 3) {
            this.state();
        }
        if (mc.player.onGround || this.air == 0) {
            mc.player.jump();
        }
        mc.player.jumpMovementFactor = 0.15f;
        mc.player.motionY += 0.05;
    }
}

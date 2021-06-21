package eu.floppaware.event.events.impl.render;

import eu.floppaware.event.events.Event;
import net.minecraft.client.gui.ScaledResolution;

public class EventRender2D implements Event {

    private final ScaledResolution sr;
    private float partialTicks;

    public EventRender2D(float partialTicks, ScaledResolution sr) {
        this.partialTicks = partialTicks;
        this.sr = sr;
    }

    public float getPartialTicks() {
        return partialTicks;
    }

    public void setPartialTicks(float partialTicks) {
        this.partialTicks = partialTicks;
    }

    public ScaledResolution getSr() {
        return sr;
    }
}

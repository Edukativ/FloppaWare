package eu.floppaware.event.events.impl.render;

import eu.floppaware.event.events.Event;
import eu.floppaware.event.types.EventType;

public class EventRenderScoreboard
        implements Event {
    EventType state;

    public EventRenderScoreboard(EventType state) {
        this.state = state;
    }

    public EventType getState() {
        return this.state;
    }

    public boolean isPre() {
        return this.state.equals(EventType.PRE);
    }

    public void setState(EventType state) {
        this.state = state;
    }
}


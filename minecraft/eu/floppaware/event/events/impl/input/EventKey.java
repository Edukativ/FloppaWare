package eu.floppaware.event.events.impl.input;

import eu.floppaware.event.events.Event;

public class EventKey implements Event {

    private int key;

    public EventKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}

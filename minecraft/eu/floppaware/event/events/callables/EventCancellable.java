package eu.floppaware.event.events.callables;

import eu.floppaware.event.events.Cancellable;
import eu.floppaware.event.events.Event;

/**
 * Abstract example implementation of the Cancellable interface.
 *
 * @author DarkMagician6
 * @since August 27, 2013
 */
public abstract class EventCancellable implements Event, Cancellable {

    private boolean cancelled;

    protected EventCancellable() {
    }

    /**
     * @see Cancellable.isCancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * @see Cancellable.setCancelled
     */
    @Override
    public void setCancelled(boolean state) {
        cancelled = state;
    }

}

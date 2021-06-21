package eu.floppaware.settings.impl;

import eu.floppaware.settings.Setting;

public class BooleanSetting extends Setting {

    private boolean state;

    public BooleanSetting(String name, boolean state) {
        this.name = name;
        this.state = state;
    }

    public boolean getCurrentValue() {
        return state;
    }

    public void setValue(boolean state) {
        this.state = state;
    }
}

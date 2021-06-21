package eu.floppaware.settings.impl;

import eu.floppaware.settings.Setting;

import java.util.Arrays;
import java.util.List;

public class ListSetting extends Setting {

    public final List<String> modes;
    public String activeMode;
    public int index;

    public ListSetting(String name, String activeMode, String... options) {
        this.name = name;
        this.modes = Arrays.asList(options);
        this.index = modes.indexOf(activeMode);
        this.activeMode = modes.get(index);
    }

    public void changeMode() {
        if (index < modes.size() - 1) {
            index++;
            activeMode = modes.get(index);
        } else if (index >= modes.size() - 1) {
            index = 0;
            activeMode = modes.get(0);
        }
    }

    public String getCurrentMode() {
        return activeMode;
    }

    public void setCurrentMode(String selected) {
        this.activeMode = selected;
        this.index = this.modes.indexOf(selected);
    }

    public String getOptions() {
        return this.modes.get(this.index);
    }
}

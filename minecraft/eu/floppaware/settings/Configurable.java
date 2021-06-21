package eu.floppaware.settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Configurable {

    private final List<Setting> settingList = new ArrayList<>();

    public final void addSettings(Setting... options) {
        settingList.addAll(Arrays.asList(options));
    }

    public final List<Setting> getOptions() {
        return this.settingList;
    }

    public Setting getSettingByName(String name) {
        for (Setting set : getOptions()) {
            if (set.getName().equalsIgnoreCase(name)) {
                return set;
            }
        }
        return null;
    }
}

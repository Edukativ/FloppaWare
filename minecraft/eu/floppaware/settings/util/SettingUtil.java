package eu.floppaware.settings.util;

import eu.floppaware.feature.Feature;
import eu.floppaware.settings.Setting;
import eu.floppaware.settings.impl.BooleanSetting;
import eu.floppaware.settings.impl.ListSetting;
import eu.floppaware.settings.impl.NumberSetting;

import java.util.ArrayList;

public class SettingUtil {

    public static SettingUtil instance = new SettingUtil();

    public ArrayList<BooleanSetting> getBooleanValues(Feature feature) {
        ArrayList<BooleanSetting> booleanSettings = new ArrayList<>();
        for (Setting setting : feature.getOptions()) {
            if (!(setting instanceof BooleanSetting))
                continue;

            BooleanSetting numberSetting = (BooleanSetting) setting;
            booleanSettings.add(numberSetting);
        }
        return booleanSettings;
    }

    public ArrayList<ListSetting> getEnumSetting(Feature feature) {
        ArrayList<ListSetting> listSettings = new ArrayList<>();
        for (Setting setting : feature.getOptions()) {
            if (!(setting instanceof ListSetting))
                continue;
            ListSetting numberSetting = (ListSetting) setting;
            listSettings.add(numberSetting);
        }
        return listSettings;
    }

    public ArrayList<NumberSetting> getNumberValues(Feature feature) {
        ArrayList<NumberSetting> numberSettings = new ArrayList<>();
        for (Setting setting : feature.getOptions()) {
            if (!(setting instanceof NumberSetting))
                continue;
            NumberSetting numberSetting = (NumberSetting) setting;
            numberSettings.add(numberSetting);
        }
        return numberSettings;
    }

}

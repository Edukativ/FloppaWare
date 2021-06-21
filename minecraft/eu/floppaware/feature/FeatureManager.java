package eu.floppaware.feature;

import eu.floppaware.feature.impl.hud.ClickGui;
import eu.floppaware.feature.impl.hud.Hud;
import eu.floppaware.feature.impl.movement.AutoSprint;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {

    private final List<Feature> featureList = new ArrayList<>();

    public FeatureManager() {
        featureList.add(new Hud());
        featureList.add(new AutoSprint());
        featureList.add(new ClickGui());
    }

    public List<Feature> getFeatureList() {
        return featureList;
    }

    public ArrayList<Feature> getFeaturesInCategory(Category categoryIn){
        ArrayList<Feature> mods = new ArrayList<>();
        for (Feature feature : getFeatureList()) {
            if(feature.getCategory() == categoryIn)
                mods.add(feature);
        }
        return mods;
    }

    public Feature getFeatureForClass(Class<? extends Feature> classFeature) {
        for (Feature feature : getFeatureList()) {
            if (feature.getClass() == classFeature) {
                return feature;
            }
        }
        return null;
    }
}

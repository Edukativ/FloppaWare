package eu.floppaware.feature;

import eu.floppaware.feature.impl.hud.Hud;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {

    private final List<Feature> featureList = new ArrayList<>();

    public FeatureManager() {
        featureList.add(new Hud());
    }

    public List<Feature> getFeatureList() {
        return featureList;
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

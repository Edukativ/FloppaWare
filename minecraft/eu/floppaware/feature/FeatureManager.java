package eu.floppaware.feature;

import eu.floppaware.feature.impl.hud.*;
import eu.floppaware.feature.impl.movement.*;
import eu.floppaware.feature.impl.combat.*;
import eu.floppaware.feature.impl.player.*;
import eu.floppaware.feature.impl.visuals.*;
import eu.floppaware.feature.impl.misc.*;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {

    private final List<Feature> featureList = new ArrayList<>();

    public FeatureManager() {
        
    	//Combat
    	featureList.add(new TriggerBot());
    	featureList.add(new PushAttack());
//    	featureList.add(new Velocity());
    	
    	//Movement
    	featureList.add(new NoJumpDelay());
    	featureList.add(new AutoSprint());
    	
        
    	//Player
        featureList.add(new FastPlace());
        featureList.add(new Parkour());
        featureList.add(new NoPush());
        featureList.add(new NoWeb());
        
    	
    	//Visuals
        featureList.add(new ShaderESP());
        featureList.add(new Bright());
    	
        
    	//Misc
        featureList.add(new ElytraFly());
        featureList.add(new AntiRain());
//        featureList.add(new Timer());
    	
        
    	//Hud
    	featureList.add(new Hud());
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

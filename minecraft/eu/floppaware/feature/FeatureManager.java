package eu.floppaware.feature;

import eu.floppaware.feature.impl.hud.*;
import eu.floppaware.feature.impl.movement.*;
import eu.floppaware.feature.impl.combat.*;
import eu.floppaware.feature.impl.player.*;
import eu.floppaware.feature.impl.visuals.*;
import eu.floppaware.feature.impl.misc.*;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {

    private final List<Feature> featureList = new ArrayList<>();

    public FeatureManager() {
        
    	//Combat

        featureList.add(new AutoGapple());
    	featureList.add(new TriggerBot());
    	featureList.add(new PushAttack());
        featureList.add(new FastBow());


    	//Movement
        featureList.add(new InventoryWalk());
        featureList.add(new NoJumpDelay());
        featureList.add(new AirJump());
    	featureList.add(new AutoSprint());
        featureList.add(new ElytraFly());
        featureList.add(new LongJump());
    	featureList.add(new Parkour());

        
    	//Player
        featureList.add(new FastPlace());
        featureList.add(new NoPush());
        featureList.add(new NoWeb());
        featureList.add(new AutoWalk());
        //featureList.add(new XCarry());
        
    	
    	//Visuals
        featureList.add(new ShaderESP());
        featureList.add(new AntiRain());
        featureList.add(new Bright());
        featureList.add(new NoBob());
        featureList.add(new ESP());
    	
        
    	//Misc
        featureList.add(new MCFriends());


    	//Hud
    	featureList.add(new Hud());
        featureList.add(new ClickGui());
        this.featureList.sort((m1, m2) -> (int) (Minecraft.getMinecraft().fontRendererObj.getStringWidth(m2.getLabel()) - Minecraft.getMinecraft().fontRendererObj.getStringWidth(m1.getLabel())));


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

package eu.floppaware;

import eu.floppaware.event.EventManager;
import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.input.EventKey;
import eu.floppaware.feature.Feature;
import eu.floppaware.feature.FeatureManager;
import eu.floppaware.ui.click.ClickGui;

public class Main {

    public static String name = "FloppaWare", build = "010", status = "Alpha+";

    public static Main instance = new Main();
    public FeatureManager featureManager;
    public ClickGui clickGui;

    public void loadClient() {
        this.featureManager = new FeatureManager();
        this.clickGui = new ClickGui();
        EventManager.register(this);
    }

    @EventTarget
    public void onKey(EventKey event) {
        for (Feature feature : featureManager.getFeatureList()) {
            if (feature.getKey() == event.getKey()) {
                feature.state();
            }
        }
    }
}

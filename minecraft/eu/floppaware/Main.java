package eu.floppaware;

import eu.floppaware.event.EventManager;
import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.input.EventKey;
import eu.floppaware.feature.Feature;
import eu.floppaware.feature.FeatureManager;

public class Main {

    public static String name = "МАТЬ РУСЛАНА ШЛЮХА ЕБАННАЯ", build = "001", status = "Alpha";

    public static Main instance = new Main();
    public FeatureManager featureManager;//сын шлюхи ебанной гетни воспитание  да я твоей матери в ебало рыгнул

    public void loadClient() {
        this.featureManager = new FeatureManager();
        EventManager.register(this);
        //мать руслана шлюха ушастая
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

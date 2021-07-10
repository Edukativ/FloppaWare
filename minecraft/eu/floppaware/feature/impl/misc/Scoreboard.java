package eu.floppaware.feature.impl.misc;

import eu.floppaware.Main;
import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.render.EventRenderScoreboard;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.settings.Setting;
import net.minecraft.client.renderer.GlStateManager;

public class Scoreboard
        extends Feature {

    public Setting x;
    public Setting y;

    public Scoreboard() {
        super("Scoreboard", Category.Misc);
        Main.instance.setmgr.rSetting(new Setting("NoScoreBoard", this, false));
        this.x = new Setting("Scoreboard X", this, 0.0, -1000.0, 1000.0, false);
        Main.instance.setmgr.rSetting(this.x);
        this.y = new Setting("Scoreboard Y", this, 0.0, -500.0, 500.0, false);
        Main.instance.setmgr.rSetting(this.y);
    }

    @EventTarget
    public void onRenderScoreboard(EventRenderScoreboard event) {
        if (event.isPre()) {
            GlStateManager.translate(-this.x.getValDouble(), this.y.getValDouble(), 1.0);
        } else {
            GlStateManager.translate(this.x.getValDouble(), -this.y.getValDouble(), 1.0);
        }
    }
}

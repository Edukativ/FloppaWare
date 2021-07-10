package eu.floppaware.feature.impl.visuals;

import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.render.EventRender3D;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.settings.impl.NumberSetting;
import eu.floppaware.utils.render.RenderUtil;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

public class ESP extends Feature {
    public static NumberSetting r;
    public static NumberSetting g;
    public static NumberSetting b;
    public static NumberSetting a;

    public ESP() {
        super("ESP", Category.Visuals);
        r = new NumberSetting("Red", 255.0f, 0.0f, 255.0f, 0.1f);
        g = new NumberSetting("Green", 255.0f, 0.0f, 255.0f, 0.1f);
        b = new NumberSetting("Blue", 255.0f, 0.0f, 255.0f, 0.1f);
        a = new NumberSetting("Alpha", 255.0f, 0.0f, 255.0f, 0.1f);
        addSettings(r, g, b, a);
    }

    @EventTarget
    public void onRender3d(EventRender3D event) {
        for (final EntityPlayer ent : mc.world.playerEntities) {
            if (ent == mc.player) {
                continue;
            }
            mc.getRenderManager();
            final RenderManager renderManager = mc.getRenderManager();
            final double renderPosX = renderManager.viewerPosX;
            final double renderPosY = renderManager.viewerPosY;
            final double renderPosZ = renderManager.viewerPosZ;
            final double x = ent.lastTickPosX + (ent.posX - ent.lastTickPosX) * 0 - renderPosX;
            final double y = ent.lastTickPosY + (ent.posY - ent.lastTickPosY) * 0 - renderPosY;
            final double z = ent.lastTickPosZ + (ent.posZ - ent.lastTickPosZ) * 0 - renderPosZ;
            RenderUtil.rfB(new AxisAlignedBB(x - 0.3, y, z - 0.3, x + 0.3, y + 1.8, z + 0.3), (float) r.getCurrentValue() / 255.0f, (float) g.getCurrentValue() / 255.0f, (float) b.getCurrentValue() / 255.0f, (float) a.getCurrentValue() / 255.0f);
        }
    }
}
package eu.floppaware.feature;

import eu.floppaware.event.EventManager;
import eu.floppaware.settings.Configurable;
import net.minecraft.client.Minecraft;

public class Feature extends Configurable {

    protected static Minecraft mc = Minecraft.getMinecraft();
    private final Category category;
    private String label;
    private int key;
    private boolean state;
    public boolean hidden;
    
    public static boolean check() {
        return mc.player == null || mc.world == null;
    }

    public Feature(String label, Category category) {
        this.label = label;
        this.category = category;
        this.key = 0;
        this.state = false;
        this.hidden = false;
    }

    public void onEnable() {
        EventManager.register(this);
    }

    public void onDisable() {
        EventManager.unregister(this);
    }

    public void state() {
        this.state = !this.state;

        if (this.state) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    }

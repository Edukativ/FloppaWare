package eu.floppaware.settings.impl;

import eu.floppaware.settings.Setting;

public class NumberSetting extends Setting {

    private float current, minimum, maximum, increment;

    public NumberSetting(String name, float current, float minimum, float maximum, float increment) {
        this.name = name;
        this.minimum = minimum;
        this.current = current;
        this.maximum = maximum;
        this.increment = increment;
    }

    public float getMinimum() {
        return minimum;
    }

    public void setMinimum(float minimum) {
        this.minimum = minimum;
    }

    public float getMaximum() {
        return maximum;
    }

    public void setMaximum(float maximum) {
        this.maximum = maximum;
    }

    public float getCurrentValue() {
        return current;
    }

    public void setCurrentValue(float current) {
        this.current = current;
    }

    public float getIncrement() {
        return increment;
    }

    public void setIncrement(float increment) {
        this.increment = increment;
    }
}

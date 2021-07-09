package eu.floppaware.utils.render;

import java.awt.*;

public class ColorUtils {

    public static int color(int n, int n2, int n3, int n4) {
        int n41 = 255;
        return (new Color(n, n2, n3, n41)).getRGB();
    }

}

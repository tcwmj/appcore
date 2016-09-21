package org.yiwan.appcore.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

/**
 * @author Kenny Wang
 */
public class ColorHelper extends Color {

    @SuppressWarnings("unused")
    private final static Logger logger = LoggerFactory.getLogger(ColorHelper.class);
    /**
     *
     */
    private final static long serialVersionUID = 1L;

    public ColorHelper(int r, int g, int b) {
        super(r, g, b);
    }

    /**
     * * Returns a web browser-friendly HEX value representing the colour in the
     * default sRGB * ColorModel. * * @param r red * @param g green * @param b
     * blue * @return a browser-friendly HEX value
     */
    public static String toHex(int r, int g, int b) {
        return "#" + toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
    }

    private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }

    /**
     * @param rgbaExpression : example is rgba(181, 217, 245, 1) or rgb(181, 217, 245),
     *                       generated by getCSSValue in WebElement
     * @return : example is #B5D9F5
     */
    public static String RGBAtoHex(String rgbaExpression) {
        String[] rgba = rgbaExpression.toLowerCase().replace("rgba(", "").replace("rgb(", "").replace(")", "").split(",");
        return new ColorHelper(Integer.parseInt(rgba[0].trim()), Integer.parseInt(rgba[1].trim()), Integer.parseInt(rgba[2].trim())).getHex();
    }

    /**
     * * Returns the HEX value representing the colour in the default sRGB
     * ColorModel. * * @return the HEX value of the colour in the default sRGB
     * ColorModel
     */
    public String getHex() {
        return toHex(getRed(), getGreen(), getBlue());
    }
}
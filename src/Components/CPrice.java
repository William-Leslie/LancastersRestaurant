package Components;

import java.text.*;

/**
 * Utility to format price values consistently
 */
public class CPrice {
    private static final NumberFormat formatter = new DecimalFormat("£0.00");

    /** Get the formatted representation of this price
     * @param value the price value
     * @return string of formatted value
     */
    public static String of(double value) {
        return CPrice.formatter.format(value);
    }
}

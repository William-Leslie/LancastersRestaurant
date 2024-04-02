package Components;

import java.text.*;

public class CPrice {
    private static final NumberFormat formatter = new DecimalFormat("0.00£");

    public static String of(double value) {
        return CPrice.formatter.format(value);
    }
}

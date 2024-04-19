package Components;

import java.time.*;
import java.time.format.*;

/**
 * Utility to format date values consistently
 */
public class CDate {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");

    /** Get the formatted representation of this date
     * @param date the date value
     * @return string of formatted date value
     */
    public static String of(LocalDate date) {
        return date.format(CDate.formatter);
    }
}

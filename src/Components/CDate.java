package Components;

import java.time.*;
import java.time.format.*;

public class CDate {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");

    public static String of(LocalDate date) {
        return date.format(CDate.formatter);
    }
}

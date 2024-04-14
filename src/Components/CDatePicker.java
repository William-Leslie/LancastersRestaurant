package Components;

import Resources.*;

import com.github.lgooddatepicker.components.*;
import com.github.lgooddatepicker.optionalusertools.*;

public class CDatePicker extends DatePicker {
    public CDatePicker() {
        super();
        this.setBackground(Colors.background);
        this.setDateToToday();
        DatePickerSettings settings = new DatePickerSettings();
        settings.setAllowEmptyDates(false);
        settings.setVisibleTodayButton(false);
        settings.setAllowKeyboardEditing(false);
        // TODO: more date picker theming (font, colors...)
        settings.setColor(DatePickerSettings.DateArea.BackgroundOverallCalendarPanel, Colors.secondary);
        settings.setColor(DatePickerSettings.DateArea.BackgroundMonthAndYearMenuLabels, Colors.secondary);
        settings.setColor(DatePickerSettings.DateArea.TextMonthAndYearMenuLabels, Colors.text);
        this.setSettings(settings);
    }
}

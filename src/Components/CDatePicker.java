package Components;

import Resources.*;

import com.github.lgooddatepicker.components.*;

/**
 * Themed date picker component
 * <p> Defaults the selected date to today
 */
public class CDatePicker extends DatePicker {

    /** Create a themed date picker component
     */
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

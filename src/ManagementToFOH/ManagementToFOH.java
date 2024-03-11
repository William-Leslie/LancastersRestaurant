package ManagementToFOH;

import java.time.DayOfWeek;
import java.time.LocalDate;

public interface ManagementToFOH {
    /** Get the menu, and all relative information, for a specific date
     * @param date The LocalDate value indicating which Menu to retrieve
     * @return The Menu object with all relative information included
     */
    public Menu getMenu(LocalDate date);

    /** Get the number of maximum allowed concurrent diners that ensures good customer service
     * @return The integer value for maximum concurrent diners
     */
    public int getMaxDiners();

    /** Get the number of maximum allowed pre-bookings before service begins
     * @return The integer value for maximum pre-booking capacity
     */
    public int getMaxBookings();

    /** Get the number of maximum allowed new customers per half-hour that ensures good customer service
     * @return The integer value for new covers/diners coming in each half-hour
     */
    public int getCoverLimit();

    /** Get total counts of diners and bookings for a specific date in the past
     * @param date The LocalDate value indicating which data to retrieve
     * @return The BookingCounts object with diner and booking counts
     * @apiNote Not requested in specification document but present in case study
     */
    public BookingCounts getPastBookingCounts(LocalDate date);

    /** Get average counts of diners and bookings for a day of the week
     * @param day The DayOfWeek value indicating which data to retrieve
     * @return The BookingCounts object with diner and booking counts
     * @apiNote Not requested in specification document but present in case study
     */
    public BookingCounts getAverageBookingCounts(DayOfWeek day);
}

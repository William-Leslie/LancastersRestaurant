package ManagementToFOH;

public interface BookingCounts {
    /** Retrieve the number of bookings / booked tables
     * @return The integer value of booked tables
     */
    public int getBookedTables();

    /** Retrieve the number of diners / covers
     * @return The integer value of diner covers
     */
    public int getDinerCovers();
}

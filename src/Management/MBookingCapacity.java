package Management;

import Resources.*;

import java.sql.*;
import java.time.*;

/**
 * Backend class for daily BookingCapacity entries
 * <p> This includes half-hour, pre-book and max-dining limits for that day
 */
public class MBookingCapacity {

    /** The date these limits apply to
     */
    public LocalDate date;

    /** The number of maximum allowed new customers per half-hour that ensures good customer service
     */
    public int halfHourLimit;

    /** The number of maximum allowed pre-bookings before service begins
     */
    public int preBookLimit;

    /** The number of maximum allowed concurrent diners that ensures good customer service
     */
    public int maxDiningLimit;

    /** Get the capacity limits for a certain date
     * @param date the relevant date to retrieve capacity for
     * @return the capacity limits for that date
     */
    public static MBookingCapacity getOnDate(LocalDate date) {
        MBookingCapacity capacity = new MBookingCapacity();

        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM BookingCapacity
                         WHERE BookingCapacity.CapacityDay = ?
                     """)) {
            stmt.setDate(1, java.sql.Date.valueOf(date));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                capacity.date = resultSet.getDate("CapacityDay").toLocalDate();
                capacity.halfHourLimit = resultSet.getInt("HalfHourLimit");
                capacity.preBookLimit = resultSet.getInt("PreBookLimit");
                capacity.maxDiningLimit = resultSet.getInt("MaxDiningLimit");

                return capacity;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        capacity.date = date;
        capacity.halfHourLimit = 6;
        capacity.preBookLimit = 10;
        capacity.maxDiningLimit = 30;
        return capacity;
    }

    /** Save changes to this date's capacity to the database
     */
    public void saveChanges() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         UPDATE BookingCapacity SET
                         BookingCapacity.HalfHourLimit = ?,
                         BookingCapacity.PreBookLimit = ?,
                         BookingCapacity.MaxDiningLimit = ?
                         WHERE BookingCapacity.CapacityDay = ?
                     """)) {
            stmt.setInt(1, this.halfHourLimit);
            stmt.setInt(2, this.preBookLimit);
            stmt.setInt(3, this.maxDiningLimit);
            stmt.setDate(4, java.sql.Date.valueOf(this.date));
            if (stmt.executeUpdate() < 1) {
                try (PreparedStatement stmt2 = conn.prepareStatement("""
                            INSERT INTO BookingCapacity
                            (CapacityDay, HalfHourLimit, PreBookLimit, MaxDiningLimit)
                            VALUES
                            (?, ?, ?, ?)
                        """)) {
                    stmt2.setDate(1, java.sql.Date.valueOf(this.date));
                    stmt2.setInt(2, this.halfHourLimit);
                    stmt2.setInt(3, this.preBookLimit);
                    stmt2.setInt(4, this.maxDiningLimit);
                    stmt2.execute();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

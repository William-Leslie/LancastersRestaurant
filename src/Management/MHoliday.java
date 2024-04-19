package Management;

import Resources.*;

import java.sql.*;
import java.time.*;
import java.util.*;

/**
 * Backend class for Holiday entries
 */
public class MHoliday {

    /** The ID of the staff taking this holiday
     */
    public int staffID;

    /** The date this holiday starts
     */
    public LocalDate start;

    /** The date this holiday ends
     */
    public LocalDate end;

    /** Get ongoing holidays for a certain date
     * @param date the date to retrieve ongoing holidays for
     * @return list of ongoing holidays for that date
     */
    public static List<MHoliday> getOnDate(LocalDate date) {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Holiday
                         WHERE ? BETWEEN Holiday.FromDate AND Holiday.ToDate
                     """)) {
            stmt.setDate(1, java.sql.Date.valueOf(date));
            ResultSet resultSet = stmt.executeQuery();
            List<MHoliday> holidays = new ArrayList<>();

            while (resultSet.next()) {
                MHoliday holiday = new MHoliday();
                holiday.staffID = resultSet.getInt("StaffID");
                holiday.start = resultSet.getDate("FromDate").toLocalDate();
                holiday.end = resultSet.getDate("ToDate").toLocalDate();

                holidays.add(holiday);
            }

            return holidays;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /** Add this new holiday entry to the database
     */
    public void addToDB() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         INSERT INTO Holiday
                         (StaffID, FromDate, ToDate)
                         VALUES
                         (?, ?, ?)
                     """)) {
            stmt.setInt(1, this.staffID);
            stmt.setDate(2, java.sql.Date.valueOf(this.start));
            stmt.setDate(3, java.sql.Date.valueOf(this.end));
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

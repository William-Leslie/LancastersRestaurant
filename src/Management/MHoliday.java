package Management;

import Resources.*;

import java.sql.*;
import java.time.*;
import java.util.*;

public class MHoliday {
    public int staffID;
    public LocalDate start;
    public LocalDate end;

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
}

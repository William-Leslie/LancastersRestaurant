package Management;

import Resources.*;

import java.sql.*;
import java.time.*;
import java.util.*;

public class MStaffMember {
    public int id;
    public String name;
    public String address;
    public LocalDate dateOfBirth;
    public String role;

    public static List<MStaffMember> getStaff() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM StaffMember
                     """)) {
            ResultSet resultSet = stmt.executeQuery();
            List<MStaffMember> staff = new ArrayList<>();

            while (resultSet.next()) {
                MStaffMember member = new MStaffMember();
                member.id = resultSet.getInt("StaffMember.StaffID");
                member.name = resultSet.getString("StaffMember.StaffName");
                member.address = resultSet.getString("StaffMember.Address");
                member.dateOfBirth = resultSet.getDate("StaffMember.DateOfBirth").toLocalDate();
                member.role = resultSet.getString("StaffMember.Role");

                staff.add(member);
            }

            return staff;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

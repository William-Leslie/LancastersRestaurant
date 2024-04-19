package Management;

import Resources.*;

import java.sql.*;
import java.time.*;
import java.util.*;

/**
 * Backend class for StaffMember entries
 */
public class MStaffMember {

    /** Unique identifier for this staff member
     */
    public int id;

    /** THe staff member's name
     */
    public String name;

    /** Current home address of this staff member
     */
    public String address;

    /** Date of birth of this staff member
     */
    public LocalDate dateOfBirth;

    /** The role of this staff member
     */
    public String role;

    /** Get all employed staff members
     * @return list of employed staff members
     */
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

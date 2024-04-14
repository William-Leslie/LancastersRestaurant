package Management;

import Resources.*;

import java.sql.*;

public class MAuthUser {
    private static boolean loggedIn;
    public static String username;
    public static String role;

    public static boolean login(String username, String password) {
        if (MAuthUser.loggedIn) {
            return true;
        }

        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                        SELECT * FROM AuthUser
                        WHERE username = ? AND password = ?
                     """)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                MAuthUser.username = resultSet.getString("AuthUser.Username");
                MAuthUser.role = resultSet.getString("AuthUser.Role");
                MAuthUser.loggedIn = true;

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void logout() {
        MAuthUser.loggedIn = false;
        MAuthUser.username = null;
        MAuthUser.role = null;
    }
}

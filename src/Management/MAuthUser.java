package Management;

import Resources.*;

import java.sql.*;

/**
 * Backend class for user authentication
 */
public class MAuthUser {
    private static boolean loggedIn;

    /** The currently logged-in user's name
     */
    public static String username;

    /** The currently logged-in user's role
     */
    public static String role;

    /** Login to user account
     * @param username the account's username
     * @param password the account's password
     * @return whether login was successful, or already logged in
     */
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

            if (resultSet.next()) {
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

    /** Logout of user account
     */
    public static void logout() {
        MAuthUser.loggedIn = false;
        MAuthUser.username = null;
        MAuthUser.role = null;
    }
}

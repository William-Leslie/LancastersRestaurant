package Resources;

import java.sql.*;

/**
 * Utility class to access a connection to the database
 */
public class Database {
    private static final String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t30";
    private static final String username = "in2033t30_a";
    private static final String password = "ZSsixpPY6cQ";

    /** Open and retrieve a connection to the database
     * @return an open connection to the database
     * @throws SQLException a connection to the database could not be established
     */
    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

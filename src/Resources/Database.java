package Resources;

import java.sql.*;

public class Database {
    private static final String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t30";
    private static final String username = "in2033t30_a";
    private static final String password = "ZSsixpPY6cQ";

    public static Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

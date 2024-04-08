package Resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public  class Database {
    static String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t30";
    static String username = "in2033t30_a";
    static String password = "ZSsixpPY6cQ";

    public static List<Object[]> getIngredientsTable() {
        List<Object[]> data = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Ingredient");
            while (resultSet.next()) {
                // Extract data from the result set
                int ingredientID = resultSet.getInt("IngredientID");
                String ingredientName = resultSet.getString("IngredientName");
                int quantity = resultSet.getInt("Quantity");
                int stockLevel = resultSet.getInt("StockLevel");
                int lowStockThreshold = resultSet.getInt("LowStockThreshold");

                // Add a row of data to the list
                Object[] rowData = {ingredientID, ingredientName, quantity, stockLevel, lowStockThreshold};
                data.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}

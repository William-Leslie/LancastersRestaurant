package Resources;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
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
                float price = resultSet.getFloat("Price");

                // Add a row of data to the list
                Object[] rowData = {ingredientName, quantity, stockLevel, lowStockThreshold, price};
                data.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<Object[]> getDishesTable() {
        List<Object[]> data = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Dish");
            while (resultSet.next()) {
                int dishID = resultSet.getInt("DishID");
                String dishName = resultSet.getString("DishName");
                double price = resultSet.getDouble("Price");
                String description = resultSet.getString("Description");

                Object[] rowData = {dishName, price, description};
                data.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<Object[]> getWinesTable() {
        List<Object[]> data = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Wine");
            while (resultSet.next()) {
                // Extract data from the result set
                int wineID = resultSet.getInt("WineID");
                String wineName = resultSet.getString("WineName");
                String wineYear = resultSet.getString("WineYear");
                double price = resultSet.getDouble("Price");
                int stockLevel = resultSet.getInt("StockLevel");

                // Add a row of data to the list
                Object[] rowData = {wineName, wineYear, price, stockLevel};
                data.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<Object[]> getBookingsTable() {
        List<Object[]> data = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Booking");
            while (resultSet.next()) {
                // Extract data from the result set
                int bookingID = resultSet.getInt("BookingID");
                String bookingName = resultSet.getString("BookingName");
                String contact = resultSet.getString("Contact");
                String type = resultSet.getString("Type");
                int noOfCovers = resultSet.getInt("noOfCovers");

                // Add a row of data to the list
                Object[] rowData = {bookingName, contact, type, noOfCovers};
                data.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}

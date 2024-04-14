package Management;

import Resources.*;

import java.sql.*;
import java.util.*;
import java.util.List;

public class MIngredient {
    public int id;
    public String name;
    public String unit;
    public int stock;
    public int threshold;
    public double price;

    public static List<MIngredient> getInventory() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Ingredient
                     """)) {
            ResultSet resultSet = stmt.executeQuery();
            List<MIngredient> inventory = new ArrayList<>();

            while (resultSet.next()) {
                MIngredient ingredient = new MIngredient();
                ingredient.id = resultSet.getInt("Ingredient.IngredientID");
                ingredient.name = resultSet.getString("Ingredient.IngredientName");
                ingredient.unit = resultSet.getString("Ingredient.IngredientUnit");
                ingredient.stock = resultSet.getInt("Ingredient.StockLevel");
                ingredient.threshold = resultSet.getInt("Ingredient.lowStockThreshold");
                ingredient.price = resultSet.getDouble("Ingredient.Price");

                inventory.add(ingredient);
            }

            return inventory;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

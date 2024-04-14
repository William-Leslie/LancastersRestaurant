package Management;

import Resources.*;

import java.sql.*;
import java.util.*;

public class MIngredient {
    public int id;
    public String name;
    public String unit;
    public int stock;
    public int threshold;
    public double price;
    public MAllergen allergen;

    public static List<MIngredient> getInventory() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Ingredient
                         LEFT JOIN Allergens ON Ingredient.AllergenID = Allergens.AllergenID
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
                int allergenID = resultSet.getInt("Ingredient.AllergenID");
                if (allergenID != 0) {
                    ingredient.allergen = new MAllergen();
                    ingredient.allergen.id = allergenID;
                    ingredient.allergen.name = resultSet.getString("Allergens.AllergenName");
                }

                inventory.add(ingredient);
            }

            return inventory;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveChanges() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                        UPDATE Ingredient SET
                        AllergenID = ?
                        WHERE IngredientID = ?
                     """)) {
            if (this.allergen != null) {
                stmt.setInt(1, this.allergen.id);
            } else {
                stmt.setNull(1, Types.INTEGER);
            }
            stmt.setInt(2, this.id);
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

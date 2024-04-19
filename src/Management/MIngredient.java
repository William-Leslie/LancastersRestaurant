package Management;

import Resources.*;

import java.sql.*;
import java.util.*;

/**
 * Backend class for Ingredient entries
 */
public class MIngredient {

    /** Unique identifier for this ingredient
     */
    public int id;

    /** THe ingredient's name
     */
    public String name;

    /** The unit type of this ingredient
     */
    public String unit;

    /** Current stock level of this ingredient
     */
    public int stock;

    /** The threshold below which this ingredient is considered low on stock
     */
    public int threshold;

    /** The price to order more of this ingredient from the supplier
     */
    public double price;

    /** The associated allergen with this ingredient, if applicable
     */
    public MAllergen allergen;

    /** Helper function to parse an ingredient from an SQL result set
     * @param resultSet query result set from database
     * @return parsed ingredient object
     * @throws SQLException parsing failed, some data was likely missing
     */
    public static MIngredient fromSql(ResultSet resultSet) throws SQLException {
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
        return ingredient;
    }

    /** Get all known ingredients and their stocks and allergens
     * @return list of all known ingredients
     */
    public static List<MIngredient> getInventory() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Ingredient
                         LEFT JOIN Allergens ON Ingredient.AllergenID = Allergens.AllergenID
                     """)) {
            ResultSet resultSet = stmt.executeQuery();
            List<MIngredient> inventory = new ArrayList<>();

            while (resultSet.next()) {
                MIngredient ingredient = MIngredient.fromSql(resultSet);
                inventory.add(ingredient);
            }

            return inventory;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /** Save changes of this ingredient to the database
     */
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

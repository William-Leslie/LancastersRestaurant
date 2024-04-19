package Management;

import Resources.*;

import java.sql.*;
import java.util.*;

/**
 * Backend class for Dish entries
 */
public class MDish {

    /** Unique identifier for this dish
     */
    public int id;

    /** The name of this dish
     */
    public String name;

    /** The description of the dish
     */
    public String description;

    /** The dish's price
     */
    public double price;

    /** The suggested wine for this dish, if applicable
     */
    public MWine wine;

    /** A map of ingredients and their quantities contained in this dish
     */
    public Map<MIngredient, Integer> ingredients;

    /** Get dish IDs and names
     * @return map of dish IDs to their names
     */
    public static Map<Integer, String> getDishNames() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT DishID, DishName FROM Dish
                     """)) {
            ResultSet resultSet = stmt.executeQuery();
            Map<Integer, String> dishNames = new HashMap<>();

            while (resultSet.next()) {
                dishNames.put(resultSet.getInt("DishID"), resultSet.getString("DishName"));
            }

            return dishNames;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /** Save changes of this dish to the database
     */
    public void saveChanges() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                        UPDATE Dish SET
                        Dish.DishName = ?,
                        Dish.Description = ?,
                        Dish.Price = ?,
                        Dish.WineID = ?
                        WHERE Dish.DishID = ?
                     """)) {
            stmt.setString(1, this.name);
            stmt.setString(2, this.description);
            stmt.setDouble(3, this.price);
            if (this.wine != null) {
                stmt.setInt(4, this.wine.id);
            } else {
                stmt.setNull(4, Types.INTEGER);
            }
            stmt.setInt(5, this.id);
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

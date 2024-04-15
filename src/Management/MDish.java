package Management;

import Resources.*;

import java.sql.*;
import java.util.*;

public class MDish {
    public int id;
    public String name;
    public String description;
    public double price;
    public MWine wine;
    public Map<MIngredient, Integer> ingredients;

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

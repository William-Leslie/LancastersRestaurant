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

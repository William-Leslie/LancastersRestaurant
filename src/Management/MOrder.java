package Management;

import Resources.*;

import java.sql.*;
import java.time.*;
import java.util.*;

public class MOrder {
    public int id;
    public LocalDate ordered;
    public LocalDate arrival;
    public Map<MIngredient, Integer> items;

    public void addToDB() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         INSERT INTO Orders 
                         (OrderedDate, ArrivalDate)
                         VALUES
                         (?, ?)
                     """,
                     Statement.RETURN_GENERATED_KEYS
                     )) {
            stmt.setDate(1, java.sql.Date.valueOf(this.ordered));
            stmt.setDate(2, java.sql.Date.valueOf(this.arrival));
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                this.id = rs.getInt(1);
            } else {
                throw new SQLException();
            }

            for(HashMap.Entry<MIngredient, Integer> entry : this.items.entrySet()) {
                try (PreparedStatement stmt2 = conn.prepareStatement("""
                                 INSERT INTO Ingredient_Order 
                                 (IngredientID, OrderID, Quantity)
                                 VALUES
                                 (?, ?, ?)
                             """)) {
                    stmt2.setInt(1, entry.getKey().id);
                    stmt2.setInt(2, this.id);
                    stmt2.setInt(3, entry.getValue());
                    stmt2.execute();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

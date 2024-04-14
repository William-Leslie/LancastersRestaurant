package Management;

import Resources.*;

import java.sql.*;
import java.util.*;

public class MAllergen {
    public int id;
    public String name;

    public static List<MAllergen> getAll() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Allergens
                     """)) {
            ResultSet resultSet = stmt.executeQuery();
            List<MAllergen> allergens = new ArrayList<>();

            while (resultSet.next()) {
                MAllergen allergen = new MAllergen();
                allergen.id = resultSet.getInt("Allergens.AllergenID");
                allergen.name = resultSet.getString("Allergens.AllergenName");

                allergens.add(allergen);
            }

            return allergens;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

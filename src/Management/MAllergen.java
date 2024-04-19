package Management;

import Resources.*;

import java.sql.*;
import java.util.*;

/**
 * Backend class for Allergen entries
 */
public class MAllergen {

    /** Unique identifier for this allergen
     */
    public int id;

    /** The name of the allergen
     */
    public String name;

    /** Get all known allergens
     * @return list of known allergens
     */
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

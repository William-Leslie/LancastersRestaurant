package Management;

import Components.*;
import Resources.*;

import java.sql.*;
import java.util.*;

/**
 * Backend class for Wine entries
 */
public class MWine {

    /** Unique identifier for this wine
     */
    public int id;

    /** The name of the wine
     */
    public String name;

    /** The production year of the wine
     */
    public String year;

    /** The price of the wine
     */
    public double price;

    /** The current stock level of this wine
     */
    public int stock;

    /** Get all known wines and their stock and details
     * @return list of all known wines
     */
    public static List<MWine> getCellar() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Wine
                     """)) {
            ResultSet resultSet = stmt.executeQuery();
            List<MWine> cellar = new ArrayList<>();

            while (resultSet.next()) {
                MWine wine = new MWine();
                wine.id = resultSet.getInt("Wine.WineID");
                wine.name = resultSet.getString("Wine.WineName");
                wine.year = resultSet.getString("Wine.WineYear");
                wine.price = resultSet.getDouble("Wine.Price");
                wine.stock = resultSet.getInt("Wine.StockLevel");

                cellar.add(wine);
            }

            return cellar;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /** Add this new wine to the database
     */
    public void addToDB() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         INSERT INTO Wine
                         (WineName, WineYear, Price, StockLevel)
                         VALUES
                         (?, ?, ?, ?)
                     """)) {
            stmt.setString(1, this.name);
            stmt.setString(2, this.year);
            stmt.setDouble(3, this.price);
            stmt.setInt(4, this.stock);
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Save changes of this wine to the database
     */
    public void saveChanges() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                        UPDATE Wine SET
                        WineName = ?,
                        WineYear = ?,
                        Price = ?,
                        StockLevel = ?
                        WHERE WineID = ?
                     """)) {
            stmt.setString(1, this.name);
            stmt.setString(2, this.year);
            stmt.setDouble(3, this.price);
            stmt.setInt(4, this.stock);
            stmt.setInt(5, this.id);
            stmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.name + " (" + this.year + ") " + CPrice.of(this.price);
    }
}

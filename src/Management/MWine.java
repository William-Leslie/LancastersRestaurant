package Management;

import Components.*;
import Resources.*;

import java.sql.*;
import java.util.*;

public class MWine {
    public int id;
    public String name;
    public String year;
    public double price;
    public int stock;

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

    public void saveChanges() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                        UPDATE Wine SET
                        WineName = ?,
                        WineYear = ?,
                        StockLevel = ?
                        WHERE WineID = ?
                     """)) {
            stmt.setString(1, this.name);
            stmt.setString(2, this.year);
            stmt.setInt(3, this.stock);
            stmt.setInt(4, this.id);
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

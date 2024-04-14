package Management;

import Resources.*;

import java.sql.*;
import java.util.*;

public class MWine {
    public int id;
    public String name;
    public String year;
    public double price;
    public int stock;

    public static MWine[] getCellar() {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Wine
                     """)) {
            ResultSet resultSet = stmt.executeQuery();
            List<MWine> cellar = new LinkedList<>();

            while (resultSet.next()) {
                MWine wine = new MWine();
                wine.id = resultSet.getInt("Wine.WineID");
                wine.name = resultSet.getString("Wine.WineName");
                wine.year = resultSet.getString("Wine.WineYear");
                wine.price = resultSet.getDouble("Wine.Price");
                wine.stock = resultSet.getInt("Wine.StockLevel");

                cellar.add(wine);
            }

            return cellar.toArray(new MWine[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

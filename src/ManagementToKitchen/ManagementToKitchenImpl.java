package ManagementToKitchen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.YearMonth;
import java.util.*;

public class ManagementToKitchenImpl implements ManagementToKitchen {
    private static final String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t30";
    private static final String username = "in2033t30_d";
    private static final String password = "Cl3nYGOgp0o";

    public Set<DeliveryOrder> getScheduledDeliveries(Date date) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Orders
                         LEFT JOIN Ingredient_Order ON Orders.OrderID = Ingredient_Order.OrderID
                         LEFT JOIN Ingredient ON Ingredient_Order.IngredientID = Ingredient.IngredientID
                         WHERE Orders.ArrivalDate = ?
                     """)) {
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet resultSet = stmt.executeQuery();
            HashSet<DeliveryOrder> deliveryOrders = new HashSet<>();
            DeliveryOrder deliveryOrder = null;

            while (resultSet.next()) {
                int orderID = resultSet.getInt("Orders.OrderID");
                if (deliveryOrder == null || deliveryOrder.getDeliveryOrderId() != orderID) {
                    Date arrivalDate = resultSet.getDate("Orders.ArrivalDate");
                    deliveryOrder = new DeliveryOrderImpl(
                            orderID,
                            resultSet.getDate("Orders.OrderedDate"),
                            arrivalDate.after(new Date()) ? "transit" : "delivered",
                            arrivalDate,
                            new HashMap<>()
                    );
                    deliveryOrders.add(deliveryOrder);
                }

                deliveryOrder.getOrderItems().put(resultSet.getString("Ingredient.IngredientName"), resultSet.getInt("Ingredient_Order.Quantity"));
            }

            return deliveryOrders;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<String> getSupplierIngredients(YearMonth month) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT IngredientName FROM Ingredient
                     """)) {
            ResultSet resultSet = stmt.executeQuery();
            List<String> ingredients = new ArrayList<>();

            while (resultSet.next()) {
                String ingredient = resultSet.getString("IngredientName");
                ingredients.add(ingredient);
            }

            return ingredients;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

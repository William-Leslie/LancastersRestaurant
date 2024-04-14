package Management;

import Resources.*;

import java.sql.*;
import java.time.*;
import java.util.*;

public class MMenu {
    public int id;
    public LocalDate date;
    public List<MCourse> courses;

    public static MMenu getOnDate(LocalDateTime date) {
        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Menu
                         LEFT JOIN Course_Menu ON Menu.MenuID = Course_Menu.MenuID
                         LEFT JOIN Dish_Course ON Course_Menu.CourseID = Dish_Course.CourseID
                         LEFT JOIN Dish ON Dish_Course.DishID = Dish.DishID
                         LEFT JOIN Ingredient_Dish ON Dish.DishID = Ingredient_Dish.DishID
                         LEFT JOIN Ingredient ON Ingredient_Dish.IngredientID = Ingredient.IngredientID
                         LEFT JOIN Wine ON Dish.WineID = Wine.WineID
                         WHERE Menu.MenuDate = ?
                     """)) {
            stmt.setDate(1, java.sql.Date.valueOf(date.toLocalDate()));
            ResultSet resultSet = stmt.executeQuery();
            MMenu menu = null;

            while (resultSet.next()) {
                if (menu == null) {
                    menu = new MMenu();
                    menu.id = resultSet.getInt("Menu.MenuID");
                    menu.date = resultSet.getDate("Menu.MenuDate").toLocalDate();
                    menu.courses = new ArrayList<>();
                }

                int courseID = resultSet.getInt("Dish_Course.CourseID");
                MCourse course;
                if (menu.courses.isEmpty() || menu.courses.get(menu.courses.size() - 1).id != courseID) {
                    course = new MCourse();
                    course.id = courseID;
                    course.dishes = new ArrayList<>();
                    menu.courses.add(course);
                } else {
                    course = menu.courses.get(menu.courses.size() - 1);
                }

                int dishID = resultSet.getInt("Dish.DishID");
                MDish dish;
                if (course.dishes.isEmpty() || course.dishes.get(course.dishes.size() - 1).id != dishID) {
                    dish = new MDish();
                    dish.id = dishID;
                    dish.name = resultSet.getString("Dish.DishName");
                    dish.description = resultSet.getString("Dish.Description");
                    dish.price = resultSet.getDouble("Dish.Price");
                    int wineID = resultSet.getInt("Dish.WineID");
                    if (wineID != 0) {
                        MWine wine = new MWine();
                        wine.id = wineID;
                        wine.name = resultSet.getString("Wine.WineName");
                        wine.year = resultSet.getString("Wine.WineYear");
                        wine.price = resultSet.getDouble("Wine.Price");
                        wine.stock = resultSet.getInt("Wine.StockLevel");
                        dish.wine = wine;
                    }
                    dish.ingredients = new HashMap<>();
                    course.dishes.add(dish);
                } else {
                    dish = course.dishes.get(course.dishes.size() - 1);
                }

                int quantity = resultSet.getInt("Ingredient_Dish.Quantity");
                if (quantity == 0) {
                    continue;
                }

                MIngredient ingredient = new MIngredient();
                ingredient.id = resultSet.getInt("Ingredient.IngredientID");
                ingredient.name = resultSet.getString("Ingredient.IngredientName");
                ingredient.stock = resultSet.getInt("Ingredient.StockLevel");
                ingredient.threshold = resultSet.getInt("Ingredient.lowStockThreshold");
                ingredient.price = resultSet.getDouble("Ingredient.Price");

                dish.ingredients.put(ingredient, quantity);
            }

            // FIXME: fetch and compare from kitchen

            return menu;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void saveChanges() {
        for (MCourse course : courses) {
            course.saveChanges();
        }
    }
}

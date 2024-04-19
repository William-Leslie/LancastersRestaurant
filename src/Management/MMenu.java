package Management;

import Resources.*;

import java.sql.*;
import java.time.*;
import java.util.*;

/**
 * Backend class for Menu entries
 */
public class MMenu {

    /** Unique identifier for this menu
     */
    public int id;

    /** Date this menu will start being used, will be a Monday
     */
    public LocalDate date;

    /** List of courses that are in this menu, will contain 3 courses
     */
    public List<MCourse> courses;

    /** Get menu starting on this date, only Monday values will give results
     * @param date the date of the menu to retrieve
     * @return the menu for that date
     */
    public static MMenu getOnDate(LocalDate date) {
        // NOTE: This should have connected to Kitchen to get new Menu, but we were never given an API

        try (Connection conn = Database.connection();
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM Menu
                         LEFT JOIN Course_Menu ON Menu.MenuID = Course_Menu.MenuID
                         LEFT JOIN Dish_Course ON Course_Menu.CourseID = Dish_Course.CourseID
                         LEFT JOIN Dish ON Dish_Course.DishID = Dish.DishID
                         LEFT JOIN Ingredient_Dish ON Dish.DishID = Ingredient_Dish.DishID
                         LEFT JOIN Ingredient ON Ingredient_Dish.IngredientID = Ingredient.IngredientID
                         LEFT JOIN Allergens ON Ingredient.AllergenID = Allergens.AllergenID
                         LEFT JOIN Wine ON Dish.WineID = Wine.WineID
                         WHERE Menu.MenuDate = ?
                     """)) {
            stmt.setDate(1, java.sql.Date.valueOf(date));
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

                MIngredient ingredient = MIngredient.fromSql(resultSet);
                dish.ingredients.put(ingredient, quantity);
            }

            return menu;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /** Save changes of this menu's items to the database
     */
    public void saveChanges() {
        for (MCourse course : courses) {
            course.saveChanges();
        }
    }
}

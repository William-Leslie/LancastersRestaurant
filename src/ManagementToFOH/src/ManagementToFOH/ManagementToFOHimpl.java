package ManagementToFOH;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagementToFOHimpl implements ManagementToFOH {
    private static final String url = "jdbc:mysql://smcse-stuproj00.city.ac.uk:3306/in2033t30";
    private static final String username = "in2033t30_d";
    private static final String password = "Cl3nYGOgp0o";

    public Menu getMenu(LocalDate date) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
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
            Menu menu = null;

            while (resultSet.next()) {
                if (menu == null) {
                    menu = new MenuImpl(
                            resultSet.getInt("Menu.MenuID"),
                            new ArrayList<>(),
                            new ArrayList<>(),
                            new HashMap<>()
                    );
                }

                int courseID = resultSet.getInt("Dish_Course.CourseID");
                Course course;
                if (menu.getCourses().isEmpty() || menu.getCourses().get(menu.getCourses().size() - 1).getCourseID() != courseID) {
                    course = new CourseImpl(courseID, new ArrayList<>());
                    menu.getCourses().add(course);
                } else {
                    course = menu.getCourses().get(menu.getCourses().size() - 1);
                }

                int dishID = resultSet.getInt("Dish.DishID");
                Dish dish;
                if (course.getDishes().isEmpty() || course.getDishes().get(course.getDishes().size() - 1).getDishID() != dishID) {
                    dish = new DishImpl(
                            dishID,
                            resultSet.getString("Dish.DishName"),
                            resultSet.getDouble("Dish.Price"),
                            resultSet.getString("Dish.Description"),
                            new ArrayList<>()
                    );
                    int wineID = resultSet.getInt("Dish.WineID");
                    if (wineID != 0) {
                        int nowYear = LocalDate.now().getYear();
                        int wineYear = nowYear;
                        try {
                            wineYear = Integer.parseInt(resultSet.getString("Wine.WineYear"));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        Wine wine = new WineImpl(
                                wineID,
                                resultSet.getString("Wine.WineName"),
                                resultSet.getDouble("Wine.Price"),
                                nowYear - wineYear
                        );
                        menu.getWinePairings().put(dish, wine);
                    }
                    course.getDishes().add(dish);
                    menu.getDishList().add(dish);
                } else {
                    dish = course.getDishes().get(course.getDishes().size() - 1);
                }

                int quantity = resultSet.getInt("Ingredient_Dish.Quantity");
                if (quantity == 0) {
                    continue;
                }

                int allergenID = resultSet.getInt("Ingredient.AllergenID");
                if (allergenID != 0) {
                    dish.getAllergens().add(resultSet.getString("Allergens.AllergenName"));
                }
            }

            return menu;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getMaxDiners() {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM BookingCapacity
                         WHERE BookingCapacity.CapacityDay = ?
                     """)) {
            stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("MaxDiningLimit");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getMaxBookings() {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM BookingCapacity
                         WHERE BookingCapacity.CapacityDay = ?
                     """)) {
            stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("PreBookLimit");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getCoverLimit() {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement("""
                         SELECT * FROM BookingCapacity
                         WHERE BookingCapacity.CapacityDay = ?
                     """)) {
            stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("HalfHourLimit");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}

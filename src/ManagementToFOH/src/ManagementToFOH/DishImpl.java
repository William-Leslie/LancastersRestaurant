package ManagementToFOH;

import java.util.ArrayList;

public class DishImpl implements Dish {
    private final int dishID;
    private final String name;
    private final double price;
    private final String description;
    private final ArrayList<String> allergens;

    protected DishImpl(int dishID, String name, double price, String description, ArrayList<String> allergens) {
        this.dishID = dishID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.allergens = allergens;
    }

    public int getDishID() {
        return dishID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getAllergens() {
        return allergens;
    }
}

package ManagementToFOH;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuImpl implements Menu {
    private final int menuID;
    private final ArrayList<Dish> dishList;
    private final ArrayList<Course> courses;
    private final HashMap<Dish, Wine> winePairings;

    protected MenuImpl(int menuID, ArrayList<Dish> dishList, ArrayList<Course> courses, HashMap<Dish, Wine> winePairings) {
        this.menuID = menuID;
        this.dishList = dishList;
        this.courses = courses;
        this.winePairings = winePairings;
    }

    public int getMenuID() {
        return menuID;
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public HashMap<Dish, Wine> getWinePairings() {
        return winePairings;
    }
}

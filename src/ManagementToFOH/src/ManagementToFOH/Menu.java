package ManagementToFOH;

import java.util.ArrayList;
import java.util.HashMap;

public interface Menu {
    /** Get the unique identifier for this menu
     * @return the integer value of this Menu's identifier
     */
    public int getMenuID();

    /** Get the full list of dishes that are part of this menu
     * @return the HashSet of all Dish objects contained in this Menu
     * @apiNote Effectively redundant as this is the sum of all Dish objects of each Course object in the Menu
     */
    public ArrayList<Dish> getDishList();

    /** Get the list of courses that are part of this menu
     * @return the HashSet of Course objects contained in this Menu
     */
    public ArrayList<Course> getCourses();

    /** Get the wine pairings for the dishes in this menu
     * @return the HashMap of Dish objects to paired Wine objects
     */
    public HashMap<Dish, Wine> getWinePairings();
}

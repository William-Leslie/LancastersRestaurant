package ManagementToFOH;

import java.util.ArrayList;

public interface Dish {
    /** Get the unique identifier for this dish
     * @return The integer value of this Dish's identifier
     */
    public int getDishID();

    /** Get the name of this dish
     * @return The String value of this Dish's name
     */
    public String getName();

    /** Get the price of this dish
     * @return The double value of this Dish's price
     */
    public double getPrice();

    /** Get the description of this dish
     * @return The String value of this Dish's description
     */
    public String getDescription();

    /** Get the names of the allergens contained in this dish
     * @return The ArrayList of String values contained in this Dish
     */
    public ArrayList<String> getAllergens();
}

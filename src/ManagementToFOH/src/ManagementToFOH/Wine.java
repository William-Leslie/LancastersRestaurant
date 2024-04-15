package ManagementToFOH;

public interface Wine {
    /** Get the unique identifier for this wine
     * @return The integer value of this Wine's identifier
     */
    public int getWineID();

    /** Get the name of this wine
     * @return The String value of this Wine's name
     */
    public String getName();

    /** Get the price of this wine
     * @return The double value of this Wine's price
     */
    public double getPrice();

    /** Get the age of this wine
     * @return The integer value of this Wine's age in years
     */
    public int getAge();
}

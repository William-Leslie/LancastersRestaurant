package Management;

import java.util.*;

/**
 * Backend class for Course entries
 */
public class MCourse {

    /** Unique identifier for this course
     */
    public int id;

    /** List of the dishes contained in this course
     */
    public List<MDish> dishes;

    /** Save changes of this course's dishes to the database
     */
    public void saveChanges() {
        for (MDish dish : dishes) {
            dish.saveChanges();
        }
    }
}

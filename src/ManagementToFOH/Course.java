package ManagementToFOH;

import java.util.ArrayList;

public interface Course {
    /** Get the unique identifier for this course
     * @return The integer value of this Course's identifier
     */
    public int getCourseID();

    /** Get the Dish objects part of this course
     * @return The HashSet of Dish objects contained in this Course
     */
    public ArrayList<Dish> getDishes();
}

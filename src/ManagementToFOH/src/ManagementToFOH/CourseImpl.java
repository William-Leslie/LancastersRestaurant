package ManagementToFOH;

import java.util.ArrayList;

public class CourseImpl implements Course {
    private final int courseID;
    private final ArrayList<Dish> dishes;

    protected CourseImpl(int courseID, ArrayList<Dish> dishes) {
        this.courseID = courseID;
        this.dishes = dishes;
    }

    public int getCourseID() {
        return courseID;
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }
}

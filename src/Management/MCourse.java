package Management;

import java.util.*;

public class MCourse {
    public int id;
    public List<MDish> dishes;

    public void saveChanges() {
        for (MDish dish : dishes) {
            dish.saveChanges();
        }
    }
}

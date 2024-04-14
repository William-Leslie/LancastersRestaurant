package Management;

import java.util.List;

public class MCourse {
    public int id;
    public List<MDish> dishes;

    public void saveChanges() {
        for (MDish dish : dishes) {
            dish.saveChanges();
        }
    }
}

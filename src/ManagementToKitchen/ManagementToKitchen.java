package ManagementToKitchen;

import java.time.YearMonth;
import java.util.Date;
import java.util.Set;
import java.util.List;

public interface ManagementToKitchen {
    /** Get the order information scheduled to be delivered on a specific date
     * @param date The Date value indicating which DeliveryOrder objects to retrieve
     * @return The Set of all DeliveryOder objects being delivered on this Date
     */
    public Set<DeliveryOrder> getScheduledDeliveries(Date date);

    /** Get the list of available ingredients for an upcoming month
     * @param month The YearMonth value indicating which upcoming month to get data for
     * @return The List of all String ingredient names available that month
     * @apiNote A String value for ingredient name is used as Kitchen will already have further details
     */
    public List<String> getSupplierIngredients(YearMonth month);
}

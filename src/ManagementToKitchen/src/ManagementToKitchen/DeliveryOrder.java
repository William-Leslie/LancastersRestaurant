package ManagementToKitchen;

import java.util.Date;
import java.util.Map;

public interface DeliveryOrder {
    /** Get the unique identifier for this delivery
     * @return The integer value of this DeliveryOrder's identifier
     */
    public int getDeliveryOrderId();

    /** Get the date that this order was placed on
     * @return The Date value that this order was placed on
     */
    public Date getOrderDate();

    /** Get the current status of this order
     * @return The String value of this order's status
     */
    public String getOrderStatus();

    /** Get the date that this order will arrive on
     * @return The Date value that this order will arrive on
     */
    public Date getOrderArrivalDate();

    /** Get the list of ingredients and quantities contained in this order
     * @return The Map of String ingredient names to integer quantity values part of this order
     * @apiNote A String value for ingredient name is used as Kitchen will already have further details
     */
    public Map<String, Integer> getOrderItems();
}

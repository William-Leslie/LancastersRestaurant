package ManagementToKitchen;

import java.util.Date;
import java.util.Map;

public class DeliveryOrderImpl implements DeliveryOrder {
    private final int deliveryOrderId;
    private final Date orderDate;
    private final String orderStatus;
    private final Date orderArrivalDate;
    private final Map<String, Integer> orderItems;

    protected DeliveryOrderImpl(int deliveryOrderId, Date orderDate, String orderStatus, Date orderArrivalDate, Map<String, Integer> orderItems) {
        this.deliveryOrderId = deliveryOrderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderArrivalDate = orderArrivalDate;
        this.orderItems = orderItems;
    }

    public int getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Date getOrderArrivalDate() {
        return orderArrivalDate;
    }

    public Map<String, Integer> getOrderItems() {
        return orderItems;
    }
}

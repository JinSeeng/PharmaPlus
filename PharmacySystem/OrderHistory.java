package PharmacySystem;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;

    // Constructor
    public OrderHistory() {
        orders = new ArrayList<>();
    }

    // Add an order to the history
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Get the list of orders
    public List<Order> getOrders() {
        return orders;
    }
}
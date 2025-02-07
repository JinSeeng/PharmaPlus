package PharmacySystem;

import java.util.Map;

public class OrderManager {
    private StockManager stockManager;

    // Constructor
    public OrderManager(StockManager stockManager) {
        this.stockManager = stockManager;
    }

    // Place an order and update the stock
    public void placeOrder(Order order) {
        // Iterate over the entries in the order's product map
        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey(); // Get the product
            int quantity = entry.getValue();  // Get the quantity ordered
            stockManager.updateStock(product.getId(), product.getQuantiteStock() - quantity); // Update the stock
        }
    }
}
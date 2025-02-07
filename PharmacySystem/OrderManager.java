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
        for (Map.Entry<Product, Integer> entry : order.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            stockManager.updateStock(product.getId(), product.getQuantiteStock() - quantity);
        }
    }
}
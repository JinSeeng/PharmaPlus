package PharmacySystem.Order;

import PharmacySystem.Inventory.Product;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Product, Integer> products;

    // Constructor
    public Order() {
        products = new HashMap<>();
    }

    // Add a product to the order with a specific quantity
    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }

    // Get the products in the order
    public Map<Product, Integer> getProducts() {
        return products;
    }
}
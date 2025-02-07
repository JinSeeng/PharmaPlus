package PharmacySystem.Inventory;

import java.util.List;

public class StockManager {
    private List<Product> products;

    // Constructor
    public StockManager(List<Product> products) {
        this.products = products;
    }

    // Add a new product to the inventory
    public void addProduct(Product product) {
        products.add(product);
    }

    // Remove a product from the inventory
    public void removeProduct(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }

    // Update the stock quantity of a product
    public void updateStock(int productId, int quantity) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.setQuantity(quantity);
                break;
            }
        }
    }

    // Get the list of products
    public List<Product> getProducts() {
        return products;
    }

    // Find a product by name (case-insensitive)
    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Get products with low stock (quantity < 5)
    public List<Product> getLowStockProducts() {
        return products.stream().filter(p -> p.getQuantity() < 5).toList();
    }
}
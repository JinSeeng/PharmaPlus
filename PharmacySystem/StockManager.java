package PharmacySystem;

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
        System.out.println("Product added successfully: " + product.getNom());
    }

    // Remove a product from the inventory by ID
    public void removeProduct(int productId) {
        boolean removed = products.removeIf(product -> product.getId() == productId);
        if (removed) {
            System.out.println("Product with ID " + productId + " removed successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Update the stock quantity of a product by ID
    public void updateStock(int productId, int newQuantity) {
        for (Product product : products) {
            if (product.getId() == productId) {
                product.setQuantiteStock(newQuantity);
                System.out.println("Stock updated for product: " + product.getNom() + " (New quantity: " + newQuantity + ")");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }

    // Get the list of all products
    public List<Product> getProducts() {
        return products;
    }

    // Find a product by name (case-insensitive)
    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getNom().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Get products with low stock (quantity < 5)
    public List<Product> getLowStockProducts() {
        return products.stream()
                       .filter(product -> product.getQuantiteStock() < 5)
                       .toList();
    }

    // Find a product by ID
    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}
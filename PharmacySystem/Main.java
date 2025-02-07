package PharmacySystem;

public class Main {
    public static void main(String[] args) {
        // Relative path to the JSON file
        String jsonFilePath = "Resources/.vscode/json/stocks_pharma.json";

        // Load products from the JSON file
        Pharmacy pharmacy = DataManager.loadData(jsonFilePath);
        if (pharmacy == null) {
            System.out.println("Failed to load data from JSON file. Exiting...");
            return;
        }

        // Initialize StockManager with the loaded products
        StockManager stockManager = new StockManager(pharmacy.getProduits());

        // Example usage of StockManager
        System.out.println("=== Initial Products ===");
        stockManager.getProducts().forEach(product -> {
            System.out.println(
                "ID: " + product.getId() + " | " +
                "Name: " + product.getNom() + " | " +
                "Stock: " + product.getQuantiteStock()
            );
        });
    }
}
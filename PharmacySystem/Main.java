package PharmacySystem;

public class Main {
    public static void main(String[] args) {
        // Load products from the JSON file
        Pharmacy pharmacy = DataManager.loadData();
        if (pharmacy == null) {
            System.out.println("Failed to load data from JSON file. Exiting...");
            return;
        }

        // Initialize StockManager with the loaded products
        StockManager stockManager = new StockManager(pharmacy.getProduits());

        // Initialize other components
        OrderManager orderManager = new OrderManager(stockManager);
        OrderHistory orderHistory = new OrderHistory();
        UserManager userManager = new UserManager();

        // Add a default admin user
        userManager.addUser(new Admin("admin", "admin123"));

        // Add a default employee user
        userManager.addUser(new Employee("employee", "employee123"));

        // Create the console UI and start the session
        ConsoleUI consoleUI = new ConsoleUI(stockManager, orderManager, orderHistory, userManager);
        consoleUI.start();
    }
}
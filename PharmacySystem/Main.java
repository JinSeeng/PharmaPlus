package PharmacySystem;

import PharmacySystem.Inventory.Product;
import PharmacySystem.Inventory.StockManager;
import PharmacySystem.Order.OrderManager;
import PharmacySystem.Order.OrderHistory;
import PharmacySystem.User.UserManager;
import PharmacySystem.User.Admin;
import PharmacySystem.User.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        List<Product> products = new ArrayList<>();
        StockManager stockManager = new StockManager(products);
        OrderManager orderManager = new OrderManager(stockManager);
        OrderHistory orderHistory = new OrderHistory();
        UserManager userManager = new UserManager();

        // Add a default admin user
        userManager.addUser(new Admin("admin", "admin123"));

        // Create the console UI
        ConsoleUI consoleUI = new ConsoleUI(stockManager, orderManager, orderHistory, userManager);

        // Main loop to restart the session after logout
        while (true) {
            consoleUI.startSession(); // Start a new session (login and main menu)
        }
    }
}
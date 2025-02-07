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

        // Start the console user interface
        ConsoleUI consoleUI = new ConsoleUI(stockManager, orderManager, orderHistory, userManager);
        consoleUI.start();
    }
}
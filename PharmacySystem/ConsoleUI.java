package PharmacySystem;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private StockManager stockManager;
    private OrderManager orderManager;
    private OrderHistory orderHistory;
    private UserManager userManager;
    private Scanner scanner;
    private User currentUser; // To track the logged-in user

    // Constructor
    public ConsoleUI(StockManager stockManager, OrderManager orderManager, OrderHistory orderHistory, UserManager userManager) {
        this.stockManager = stockManager;
        this.orderManager = orderManager;
        this.orderHistory = orderHistory;
        this.userManager = userManager;
        this.scanner = new Scanner(System.in);
        this.currentUser = null; // No user is logged in initially
    }

    // Start the console interface
    public void start() {
        // Display welcome message
        System.out.println("=============================================");
        System.out.println("   Welcome to PharmaPlus Management System");
        System.out.println("=============================================");

        // Login loop
        while (currentUser == null) {
            login();
        }

        // Main menu loop
        boolean running = true;
        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. View product list");
            System.out.println("2. Add a new product");
            System.out.println("3. Remove a product");
            System.out.println("4. Search for a product");
            System.out.println("5. Place an order");
            System.out.println("6. View low stock products");
            System.out.println("7. View order history");
            System.out.println("8. Manage users (Admin only)");
            System.out.println("9. Save data");
            System.out.println("10. Load data");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 6:
                    displayLowStockProducts();
                    break;
                case 7:
                    displayOrderHistory();
                    break;
                case 8:
                    manageUsers();
                    break;
                case 9:
                    saveData();
                    break;
                case 10:
                    loadData();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using PharmaPlus. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Login method
    private void login() {
        System.out.println("\n=== Login ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Check if the user exists and the password is correct
        for (User user : userManager.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful! Welcome, " + username + ".");
                return;
            }
        }

        // If no user is found or the password is incorrect
        System.out.println("Invalid username or password. Please try again.");
    }
    
    // Display the list of products
    private void displayProducts() {
        List<Product> products = stockManager.getProducts();
        System.out.println("\n=== Product List ===");
    
        // Table header
        System.out.println("+----+----------------------+--------+-------+---------------+-----------------+--------------------------------+");
        System.out.println("| ID | Name                 | Price  | Stock | Category       | Subcategory     | Description                    |");
        System.out.println("+----+----------------------+--------+-------+---------------+-----------------+--------------------------------+");
    
        // Display products
        for (Product product : products) {
            // Truncate fields if necessary
            String nom = product.getNom();
            if (nom.length() > 20) {
                nom = nom.substring(0, 17) + "..."; // Truncate product name to 20 characters
            }
    
            String categorie = product.getCategorie();
            if (categorie.length() > 13) {
                categorie = categorie.substring(0, 10) + "..."; // Truncate category to 13 characters
            }
    
            String sousCategorie = product.getSousCategorie();
            if (sousCategorie.length() > 15) {
                sousCategorie = sousCategorie.substring(0, 12) + "..."; // Truncate subcategory to 15 characters
            }
    
            String description = product.getDescription();
            if (description.length() > 30) {
                description = description.substring(0, 27) + "..."; // Truncate description to 30 characters
            }
    
            // Format the product line
            String formattedLine = String.format(
                "| %-2d | %-20s | %-6.2f | %-5d | %-13s | %-15s | %-30s |",
                product.getId(),
                nom,
                product.getPrix(),
                product.getQuantiteStock(),
                categorie,
                sousCategorie,
                description
            );
            System.out.println(formattedLine);
        }
    
        // Table footer
        System.out.println("+----+----------------------+--------+-------+---------------+-----------------+--------------------------------+");
    }

    // Add a new product to the inventory
    private void addProduct() {
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Create a new product and add it to the inventory
        Product newProduct = new Product(stockManager.getProducts().size() + 1, name, price, quantity, category, "", "");
        stockManager.addProduct(newProduct);
        System.out.println("Product added successfully!");
    }

    // Remove a product from the inventory
    private void removeProduct() {
        System.out.print("Product ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        stockManager.removeProduct(id);
        System.out.println("Product removed successfully!");
    }

    // Search for a product by name
    private void searchProduct() {
        System.out.print("Product name to search: ");
        String name = scanner.nextLine();

        Product product = stockManager.findProductByName(name);
        if (product != null) {
            System.out.println("Product found: " + product.getNom() + " - " + product.getQuantiteStock() + " in stock - " + product.getPrix() + "€");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Place an order
    private void placeOrder() {
        Order order = new Order();
        boolean addingProducts = true;
        while (addingProducts) {
            System.out.print("Product ID to order: ");
            int id = scanner.nextInt();
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Find the product by ID
            Product product = stockManager.findProductById(id);
            if (product != null) {
                order.addProduct(product, quantity);
            } else {
                System.out.println("Product not found.");
            }

            // Ask if the user wants to add another product
            System.out.print("Add another product? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                addingProducts = false;
            }
        }

        // Place the order and update the stock
        orderManager.placeOrder(order);
        orderHistory.addOrder(order);
        System.out.println("Order placed successfully!");
    }

    // Display products with low stock (quantity < 5)
    private void displayLowStockProducts() {
        List<Product> lowStockProducts = stockManager.getLowStockProducts();
        System.out.println("\n=== Low Stock Products ===");
        for (Product product : lowStockProducts) {
            System.out.println(product.getNom() + " - " + product.getQuantiteStock() + " in stock");
        }
    }

    // Display the order history
    private void displayOrderHistory() {
        List<Order> orders = orderHistory.getOrders();
        System.out.println("\n=== Order History ===");
        for (Order order : orders) {
            System.out.println("Order:");
            order.getProducts().forEach((product, quantity) -> {
                System.out.println("  " + product.getNom() + " - " + quantity + " units");
            });
        }
    }

    // Manage users (Admin only)
    private void manageUsers() {
        if (currentUser instanceof Admin) {
            System.out.println("\n=== User Management ===");
            System.out.println("1. Add a user");
            System.out.println("2. Remove a user");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                System.out.print("Role (Admin/Employee): ");
                String role = scanner.nextLine();

                if (role.equalsIgnoreCase("Admin")) {
                    userManager.addUser(new Admin(username, password));
                } else if (role.equalsIgnoreCase("Employee")) {
                    userManager.addUser(new Employee(username, password));
                } else {
                    System.out.println("Invalid role.");
                }
                System.out.println("User added successfully!");
            } else if (choice == 2) {
                System.out.print("Username to remove: ");
                String username = scanner.nextLine();
                userManager.removeUser(username);
                System.out.println("User removed successfully!");
            } else {
                System.out.println("Invalid option.");
            }
        } else {
            System.out.println("Access denied. Only admins can manage users.");
        }
    }

    // Save data to a JSON file
    private void saveData() {
        Pharmacy pharmacy = new Pharmacy("PharmaPlus", "123 Rue de la Santé, Paris", stockManager.getProducts());
        DataManager.saveData(pharmacy, "pharmacy_data_updated.json");
        System.out.println("Data saved successfully!");
    }

    // Load data from a JSON file
    private void loadData() {
        Pharmacy pharmacy = DataManager.loadData();
        if (pharmacy != null) {
            stockManager = new StockManager(pharmacy.getProduits());
            System.out.println("Data loaded successfully!");
        } else {
            System.out.println("Error loading data.");
        }
    }
}
package PharmacySystem.Inventory;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String category;
    private String subCategory;
    private String description;

    // Constructor
    public Product(int id, String name, double price, int quantity, String category, String subCategory, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.subCategory = subCategory;
        this.description = description;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }
    public String getSubCategory() { return subCategory; }
    public String getDescription() { return description; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
}
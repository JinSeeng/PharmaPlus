package PharmacySystem.Inventory;

import java.util.List;

public class Pharmacy {
    private String name;
    private String address;
    private List<Product> products;

    // Constructor
    public Pharmacy(String name, String address, List<Product> products) {
        this.name = name;
        this.address = address;
        this.products = products;
    }

    // Getters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public List<Product> getProducts() { return products; }
}
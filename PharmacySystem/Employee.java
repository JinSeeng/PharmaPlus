package PharmacySystem;

public class Employee extends User {
    // Constructor
    public Employee(String username, String password) {
        super(username, password);
    }

    // Override method to return the role
    @Override
    public String getRole() {
        return "Employee";
    }
}
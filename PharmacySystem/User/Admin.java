package PharmacySystem.User;

public class Admin extends User {
    // Constructor
    public Admin(String username, String password) {
        super(username, password);
    }

    // Override method to return the role
    @Override
    public String getRole() {
        return "Admin";
    }
}
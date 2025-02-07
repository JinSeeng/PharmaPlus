package PharmacySystem.User;

public abstract class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Abstract method to get the role of the user
    public abstract String getRole();

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
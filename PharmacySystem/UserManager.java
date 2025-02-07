package PharmacySystem;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    // Constructor
    public UserManager() {
        users = new ArrayList<>();
    }

    // Add a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Remove a user by username
    public void removeUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }

    // Get the list of users
    public List<User> getUsers() {
        return users;
    }
}
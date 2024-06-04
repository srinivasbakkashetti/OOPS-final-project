package finalproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages user authentication and registration.
 */
public class UserAuthSystem {
    private List<User> newUsers;

    /**
     * Constructs a new UserAuthSystem object with an empty list of users.
     */
    public UserAuthSystem() {
        this.newUsers = new ArrayList<>();
    }

    /**
     * Registers a new user with the provided details.
     * @param userName The username of the new user.
     * @param newPassword The password of the new user.
     * @param newName The name of the new user.
     * @param newEmail The email address of the new user.
     */
    public void registerUser(String userName, String newPassword, String newName, String newEmail) {
        if (isUsernameAlreadyTaken(userName)) {
            System.out.println("Username is already taken. Please choose a different one.");
            return;
        }
        User newUser = new User(userName, newPassword, newName, newEmail);
        newUsers.add(newUser);
        System.out.println("User registered successfully!");
    }

    /**
     * Logs in a user with the provided username and password.
     * @param userName The username of the user.
     * @param newPassword The password of the user.
     * @return The logged-in user, or null if login fails.
     */
    public User userLogin(String userName, String newPassword) {
        for (User user : newUsers) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(newPassword)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Checks if a username is already taken by another user.
     * @param userName The username to check.
     * @return True if the username is already taken, otherwise false.
     */
    private boolean isUsernameAlreadyTaken(String userName) {
        for (User user : newUsers) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidNewPassword(String newPassword) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isValidNewUsername(String userName) {
        // TODO Auto-generated method stub
        return false;
    }
}

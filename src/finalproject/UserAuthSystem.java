package finalproject;
import java.util.ArrayList;
import java.util.List;
public class UserAuthSystem {
    private List<User> newUsers;
    public UserAuthSystem() {
        this.newUsers = new ArrayList<>();
    }

    public void registerUser(String userName, String newPassword, String newName, String newEmail) {
        if (isUsernameAlreadyTaken(userName)) {
            System.out.println("Username is already taken. Please choose a different one.");
            return;
        }
        User newUser = new User(userName, newPassword, newName, newEmail);
        newUsers.add(newUser);
        System.out.println("User registered successfully!");
    }

    public User userLogin(String userName, String newPassword) {
        for (User user : newUsers) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(newPassword)) {
                return user;
            }
        }
        return null;
    }

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

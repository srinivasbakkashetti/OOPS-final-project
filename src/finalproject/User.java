package finalproject;

/**
 * Represents a user of the online shopping system.
 */
public class User {
    private String userName;
    private String password;
    private String name;
    private String email;

    /**
     * Constructs a new User object with the specified attributes.
     * @param userName The username of the user.
     * @param password The password of the user.
     * @param name The name of the user.
     * @param email The email address of the user.
     */
    public User(String userName, String password, String name, String email) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    /**
     * Gets the username of the user.
     * @return The username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user.
     * @param userName The username to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password of the user.
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the name of the user.
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address of the user.
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * @param email The email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}

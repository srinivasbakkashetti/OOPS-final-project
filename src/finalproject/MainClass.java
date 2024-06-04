package finalproject;
import java.util.Scanner;
import java.util.List;
import java.util.regex.Pattern;
public class MainClass {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        User activeUser = null;
        UserAuthSystem userAuthentication = new UserAuthSystem();
        ShoppingCart shoppingCart = new ShoppingCart();
        Catalog productCatalog = new Catalog();

        // Load productList into the productCatalog
        List<Product> productList = ProductLoader.loadProducts();
        productCatalog.addproductList(productList);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Browse Products");
            System.out.println("4. Add Product to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Place Order");
            System.out.println("7. Exit");

            if (activeUser != null) {
                System.out.println("Logged in as: " + activeUser.getUserName());
            }

            System.out.print("Select an option: ");
            int userChoice = inputScanner.nextInt();
            inputScanner.nextLine(); // Consume the newline character.

            switch (userChoice) {
                case 1: // Register
                    System.out.print("Enter username: ");
                    String username = inputScanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = inputScanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = inputScanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = inputScanner.nextLine();
                    // Validate input
                    if (!isUsernameValid(username)) {
                        System.out.println("Username must contain only lowercase letters.");
                    } else if (!isPasswordValid(password)) {
                        System.out.println("Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");
                    } else if (!isNameValid(name)) {
                        System.out.println("Name must be in the format 'First Last' with the first letter of each word capitalized.");
                    } else if (!isEmailValid(email)) {
                        System.out.println("Email must contain the @ symbol.");
                    } else {
                        userAuthentication.registerUser(username, password, name, email);
                        Logger.log("User registered: " + username);
                        System.out.println("User registered successfully!");
                    }
                    break;

                case 2: // Login
                    if (activeUser != null) {
                        System.out.println("You are already logged in.");
                    } else {
                        System.out.print("Enter username: ");
                        String loginUsername = inputScanner.nextLine();
                        System.out.print("Enter password: ");
                        String loginPassword = inputScanner.nextLine();
                        activeUser = userAuthentication.userLogin(loginUsername, loginPassword);
                        if (activeUser != null) {
                            Logger.log("User logged in: " + activeUser.getUserName());
                            System.out.println("Login successful. Welcome, " + activeUser.getUserName() + "!");
                        } else {
                            Logger.log("Login failed for user: " + loginUsername);
                            System.out.println("Login failed. Please check your credentials.");
                        }
                    }
                    break;

                case 3: // Browse Products (Not implemented in this example)
                    showProductList(productCatalog.getAllproductList());
                    break;

                case 4: // Add Product to Cart (Not implemented in this example)
                    if (activeUser != null) {
                        // Placeholder for adding a product to the cart
                        System.out.print("Enter the product name to add to the cart: ");
                        String chosenProductName = inputScanner.nextLine();
                        Product chosenProduct = findProduct(productCatalog.getAllproductList(), chosenProductName);
                        if (chosenProduct != null) {
                            shoppingCart.addProduct(chosenProduct);
                            System.out.println("Product added to the cart.");
                        } else {
                            System.out.println("Product not found in the productCatalog.");
                        }
                    } else {
                        System.out.println("You need to log in to add productList to the cart.");
                    }
                    break;
                // Inside your main switch statement

                case 5: // View Cart
                    if (activeUser != null) {
                        List<Product> items = shoppingCart.getProductList();
                        System.out.println("Cart for " + activeUser.getUserName() + ":");
                        for (Product item : items) {
                            System.out.println(item.getProductName());
                        }
                        double totalCost = computeTotalCost(shoppingCart);
                        System.out.println("Total Price: $" + totalCost);
                    } else {
                        System.out.println("You need to log in to view your cart.");
                    }
                    break;

                case 6: // Place Order (Not implemented in this example)
                    if (activeUser != null) {
                        System.out.println("Placing an order...");
                        double totalCost = computeTotalCost(shoppingCart);
                        boolean paymentSuccess = new PaymentProcessor().processPayment(totalCost, "Credit Card");
                        if (paymentSuccess) {
                            Logger.log("Order placed for user: " + activeUser.getUserName());
                            System.out.println("Order placed successfully.");
                        } else {
                            Logger.log("Payment failed for user: " + activeUser.getUserName());
                            System.out.println("Payment failed. Please try again.");
                        }
                    } else {
                        System.out.println("You need to log in to place an order.");
                    }
                    break;

                case 7: // Exit
                    System.out.println("Exiting the program.");
                    inputScanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid userChoice. Please try again.");
            }
        }
    }

    // Validation methods
    private static boolean isUsernameValid(String username) {
        // Username contains all lowercase letters
        return Pattern.matches("^[a-z]+$", username);
    }

    private static boolean isPasswordValid(String password) {
        // Password contains one uppercase, one special character, one number, and all lowercase
        return Pattern.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$", password);
    }

    private static boolean isNameValid(String name) {
        // Name contains the first name and last name
        return Pattern.matches("^[A-Z][a-z]* [A-Z][a-z]*$", name);
    }

    private static boolean isEmailValid(String email) {
        // Email contains the @ symbol
        return email.contains("@");
    }

    private static void showProductList(List<Product> productList) {
        System.out.println("Product List:");
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            System.out.println((i + 1) + ". " + product.getProductName() + " - $" + product.getProductPrice());
            System.out.println("   Description: " + product.getProductDescription());
            System.out.println("   Quantity in Stock: " + product.getProductQuantityInStock());
        }
    }

// Placeholder method to find a product by name
    private static Product findProduct(List<Product> productCatalogProducts, String chosenProductName) {
        for (Product product : productCatalogProducts) {
            if (product.getProductName().equalsIgnoreCase(chosenProductName)) {
                return product;
            }
        }
        return null;
    }

// Placeholder method to calculate the total price of items in the cart
    private static double computeTotalCost(ShoppingCart shoppingCart) {
        double total = 0.0;
        for (Product product : shoppingCart.getProductList()) {
            total += product.getProductPrice();
        }
        return total;
    }
}
package finalproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainClassGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private User activeUser;
    private final UserAuthSystem userAuthentication;
    private final ShoppingCart shoppingCart;
    private final Catalog productCatalog;

    public MainClassGUI() {
        super("Online Shopping System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        userAuthentication = new UserAuthSystem();
        shoppingCart = new ShoppingCart();
        productCatalog = new Catalog();

        productCatalog.addproductList(ProductLoader.loadProducts());

        createNewGUIComponents();

        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override

            public void run() {

                new MainClassGUI();

            }

        });

    }

    private void createNewGUIComponents() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 20, 120, 30);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrationDialog();
            }
        });
        panel.add(registerButton);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(160, 20, 120, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginDialog();
            }
        });
        panel.add(loginButton);

        JButton browseProductsButton = new JButton("Browse Products");
        browseProductsButton.setBounds(20, 70, 260, 30);
        browseProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductList();
            }
        });
        panel.add(browseProductsButton);

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBounds(20, 120, 120, 30);
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewAddToCartDialog();
            }
        });
        panel.add(addToCartButton);

        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.setBounds(160, 120, 120, 30);
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCart();
            }
        });
        panel.add(viewCartButton);

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.setBounds(20, 170, 260, 30);
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
        panel.add(placeOrderButton);

        JButton removeFromCartButton = new JButton("Remove from Cart");
        removeFromCartButton.setBounds(160, 170, 120, 30);
        removeFromCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFromCartDialog();
            }
        });
        panel.add(removeFromCartButton);

        add(panel);
    }

    private void showRegistrationDialog() {
        JTextField UsernameField = new JTextField();
        JPasswordField PasswordField = new JPasswordField();
        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();

        Object[] message = {"Username:", UsernameField, "Password:", PasswordField, "Name:", nameField, "Email:", emailField};

        int option = JOptionPane.showConfirmDialog(null, message, "Registration", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String userName = UsernameField.getText();
            String password = new String(PasswordField.getPassword());
            String name = nameField.getText();
            String email = emailField.getText();

            if (!isValiduserName(userName)) {
                JOptionPane.showMessageDialog(null, "Username must contain only lowercase letters.");
            } else if (!isValidpassword(password)) {
                JOptionPane.showMessageDialog(null, "Password must contain one uppercase letter, one special character, one number, and at least 8 characters.");
            } else if (!isValidname(name)) {
                JOptionPane.showMessageDialog(null, "Name must be in the format 'First Last' with the first letter of each word capitalized.");
            } else if (!isValidemail(email)) {
                JOptionPane.showMessageDialog(null, "Email must contain the @ symbol.");
            } else {
                userAuthentication.registerUser(userName, password, name, email);
                Logger.log("User registered: " + userName);
                JOptionPane.showMessageDialog(null, "User registered successfully!");
            }
        }
    }

    private void showLoginDialog() {
        JTextField UsernameField = new JTextField();
        JPasswordField PasswordField = new JPasswordField();

        Object[] message = {"Username:", UsernameField, "Password:", PasswordField};

        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String loginUsername = UsernameField.getText();
            String loginPassword = new String(PasswordField.getPassword());

            if (activeUser!= null) {
                JOptionPane.showMessageDialog(null, "You are already logged in.");
            } else {
                activeUser= userAuthentication.userLogin(loginUsername, loginPassword);

                if (activeUser!= null) {
                    Logger.log("User logged in: " + activeUser.getUserName());
                    JOptionPane.showMessageDialog(null, "Login successful. Welcome, " + activeUser.getUserName() + "!");
                } else {
                    Logger.log("Login failed for user: " + loginUsername);
                    JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.");
                }
            }
        }
    }

    private void showProductList() {

        List<Product> productList = productCatalog.getAllproductList();


        if (!productList.isEmpty()) {

            DefaultListModel<String> listModel = new DefaultListModel<>();


            for (Product product : productList) {

                String productInfo = product.getProductName() + " - $" + product.getProductPrice()

                        + "\n Description: " + product.getProductDescription()

                        + "\n Quantity in Stock: " + product.getProductQuantityInStock() + "\n";

                listModel.addElement(productInfo);

            }


            JList<String> productListJList = new JList<>(listModel);

            JScrollPane scrollPane = new JScrollPane(productListJList);


            JOptionPane.showMessageDialog(null, scrollPane, "Product List", JOptionPane.PLAIN_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "No productList available in the productCatalog.", "Product List", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private void showNewAddToCartDialog() {

        if (activeUser!= null) {

            JTextField productnameField = new JTextField();


            Object[] message = {

                    "Enter the product name to add to the cart:", productnameField

            };


            int option = JOptionPane.showConfirmDialog(null, message, "Add to Cart", JOptionPane.OK_CANCEL_OPTION);


            if (option == JOptionPane.OK_OPTION) {

                String chosenProductName = productnameField.getText();

                Product chosenProduct = findProduct(productCatalog.getAllproductList(), chosenProductName);


                if (chosenProduct != null) {

                    shoppingCart.addProduct(chosenProduct);

                    JOptionPane.showMessageDialog(null, "Product added to the cart.");

                } else {

                    JOptionPane.showMessageDialog(null, "Product not found in the productCatalog.");

                }

            }

        } else {

            JOptionPane.showMessageDialog(null, "You need to log in to add productList to the cart.");

        }

    }

    private void removeFromCartDialog() {

        if (activeUser!= null) {

            List<Product> cartItems = shoppingCart.getProductList();


            if (!cartItems.isEmpty()) {

                JTextField productnameField = new JTextField();


                Object[] message = {

                        "Enter the product name to remove from the cart:", productnameField

                };


                int option = JOptionPane.showConfirmDialog(null, message, "Remove from Cart", JOptionPane.OK_CANCEL_OPTION);


                if (option == JOptionPane.OK_OPTION) {

                    String chosenProductName = productnameField.getText();

                    Product productToRemove = findProduct(cartItems, chosenProductName);


                    if (productToRemove != null) {

                        shoppingCart.removeProduct(productToRemove);

                        JOptionPane.showMessageDialog(null, "Product removed from the cart.");

                    } else {

                        JOptionPane.showMessageDialog(null, "Product not found in the cart.");

                    }

                }

            } else {

                JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Remove from Cart", JOptionPane.INFORMATION_MESSAGE);

            }

        } else {

            JOptionPane.showMessageDialog(null, "You need to log in to remove productList from the cart.");

        }

    }

    private Product findProduct(List<Product> productList, String chosenProductName) {

        for (Product product : productList) {

            if (product.getProductName().equalsIgnoreCase(chosenProductName)) {

                return product;

            }

        }

        return null;

    }

    private void showCart() {

        java.util.List<Product> cartItems = shoppingCart.getProductList();


        if (!cartItems.isEmpty()) {

            DefaultListModel<String> listModel = new DefaultListModel<>();


            for (Product item : cartItems) {

                String itemInfo = item.getProductName() + " - $" + item.getProductPrice();

                listModel.addElement(itemInfo);

            }


            JList<String> cartItemList = new JList<>(listModel);

            JScrollPane scrollPane = new JScrollPane(cartItemList);


            double totalCost = computeTotalCost(shoppingCart);

            String totalCostMessage = "Total Price: $" + totalCost;


            JOptionPane.showMessageDialog(null, new Object[]{scrollPane, totalCostMessage}, "Shopping Cart", JOptionPane.PLAIN_MESSAGE);

        } else {

            JOptionPane.showMessageDialog(null, "Your shopping cart is empty.", "Shopping Cart", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private void placeOrder() {

        if (activeUser!= null) {

            System.out.println("Placing an order...");


            // Placeholder for calculating total price

            double totalCost = computeTotalCost(shoppingCart);


            // Placeholder for processing payment (replace with your payment processing logic)

            boolean paymentSuccess = new PaymentProcessor().processPayment(totalCost, "Credit Card");


            if (paymentSuccess) {

                Logger.log("Order placed for user: " + activeUser.getUserName());

                JOptionPane.showMessageDialog(null, "Order placed successfully. Payment received.");

                // Clear the cart after successful payment

            } else {

                Logger.log("Payment failed for user: " + activeUser.getUserName());

                JOptionPane.showMessageDialog(null, "Payment failed. Please try again.");

            }

        } else {

            JOptionPane.showMessageDialog(null, "You need to log in to place an order.");

        }

    }

    private double computeTotalCost(ShoppingCart shoppingCart) {

        double total = 0.0;

        for (Product product : shoppingCart.getProductList()) {

            total += product.getProductPrice();

        }

        return total;

    }

    private boolean isValiduserName(String username) {

        // Username must contain only lowercase letters.

        return username.matches("^[a-z]+$");

    }

    private boolean isValidpassword(String password) {

        // Password must contain one uppercase letter, one special character, one number, and at least 8 characters.

        return password.matches("^(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=.*[0-9])(?=.*[a-z]).{8,}$");

    }

    private boolean isValidname(String name) {

        // Name must be in the format 'First Last' with the first letter of each word capitalized.

        return name.matches("^[A-Z][a-z]*\\s[A-Z][a-z]*$");

    }

    private boolean isValidemail(String email) {

        // Email must contain the @ symbol.

        return email.contains("@");

    }
}

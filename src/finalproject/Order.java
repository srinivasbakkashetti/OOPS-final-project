package finalproject;

/**
 * Represents an order made by a user.
 */
public class Order {
    private User user; // The user who placed the order
    private ShoppingCart cart; // The shopping cart containing the ordered items
    private String orderStatus; // The status of the order

    /**
     * Constructs a new order.
     * @param user The user who placed the order.
     * @param cart The shopping cart containing the ordered items.
     */
    public Order(User user, ShoppingCart cart) {
        this.user = user;
        this.cart = cart;
        this.orderStatus = "Pending";
    }

    /**
     * Places a new order.
     */
    public void placeNewOrder() {
        if (orderStatus.equals("Pending")) {
            System.out.println("Placing the order for User: " + user.getUserName());
            System.out.println("Order Details:");
            for (Product product : cart.getProductList()) {
                System.out.println(product.getProductName() + " - $" + product.getProductPrice());
            }
            System.out.println("Total Amount: $" + cart.calculateTotalAmount());
            this.orderStatus = "Placed";
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Order has already been placed.");
        }
    }

    /**
     * Gets the user who placed the order.
     * @return The user.
     */
    public User getuser() {
        return user;
    }

    /**
     * Gets the shopping cart containing the ordered items.
     * @return The shopping cart.
     */
    public ShoppingCart getcart() {
        return cart;
    }

    /**
     * Gets the status of the order.
     * @return The order status.
     */
    public String getorderStatus() {
        return orderStatus;
    }
}

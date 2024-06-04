package finalproject;
public class Order {
    private User user;
    private ShoppingCart cart;
    private String orderStatus;

    public Order(User user, ShoppingCart cart) {
        this.user = user;
        this.cart = cart;
        this.orderStatus = "Pending";
    }

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

    public User getuser() {
        return user;
    }
    public ShoppingCart getcart() {
        return cart;
    }
    public String getorderStatus() {
        return orderStatus;
    }
}

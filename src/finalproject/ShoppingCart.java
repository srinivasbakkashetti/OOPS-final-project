package finalproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart.
 */
public class ShoppingCart {
    private List<Product> productList = new ArrayList<>();

    /**
     * Adds a product to the shopping cart.
     * @param product The product to add
     */
    public void addProduct(Product product) {
        productList.add(product);
    }

    /**
     * Removes a product from the shopping cart.
     * @param product The product to remove
     */
    public void removeProduct(Product product) {
        productList.remove(product);
    }

    /**
     * Retrieves the list of products in the shopping cart.
     * @return List of products
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * Calculates the total amount of the products in the shopping cart.
     * @return Total amount
     */
    public double calculateTotalAmount() {
        double total = 0.0;
        for (Product product : productList) {
            total += product.getProductPrice();
        }
        return total;
    }
}

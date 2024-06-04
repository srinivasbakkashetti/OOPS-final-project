package finalproject;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Tests for the ShoppingCart class.
 */
public class ShoppingCartTest {

 @Test
 public void testGetTotalAmount() {
  // Load sample products
  List<Product> products = ProductLoader.loadProducts();
  // Create a shopping cart
  ShoppingCart cart = new ShoppingCart();
  // Add some products to the cart
  cart.addProduct(products.get(0)); // Laptop
  cart.addProduct(products.get(1)); // Smartwatch
  cart.addProduct(products.get(5)); // T-Shirt
  cart.addProduct(products.get(8)); // Dress
  // Calculate the expected total amount
  double expectedTotalAmount = products.get(0).getProductPrice() + products.get(1).getProductPrice()
          + products.get(5).getProductPrice() + products.get(8).getProductPrice();
  // Check if the total amount matches the expected value (with a small delta for precision issues)
  assertEquals(expectedTotalAmount, cart.calculateTotalAmount(), 0.01);
 }

 @Test
 public void testAddItem() {
  // Load sample products
  List<Product> products = ProductLoader.loadProducts();
  // Create a shopping cart
  ShoppingCart cart = new ShoppingCart();
  // Add a product to the cart
  cart.addProduct(products.get(2)); // Headphones
  // Check if the cart contains the added product
  assertEquals(1, cart.getProductList().size());
  assertEquals(products.get(2), cart.getProductList().get(0));
 }

 @Test
 public void testRemoveItem() {
  // Load sample products
  List<Product> products = ProductLoader.loadProducts();
  // Create a shopping cart
  ShoppingCart cart = new ShoppingCart();
  // Add a product to the cart
  Product product = products.get(3); // Smartphone
  cart.addProduct(product);
  // Remove the product from the cart
  cart.removeProduct(product);
  // Check if the cart is empty after removing the product
  assertEquals(0, cart.getProductList().size());
 }
}

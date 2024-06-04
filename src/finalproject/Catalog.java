package finalproject;

import java.util.ArrayList;
import java.util.List;

/**
 * The Catalog class represents a catalog of products.
 */
public class Catalog {
    // Private field to store the list of products.
    private List<Product> productList = new ArrayList<>();

    /**
     * Adds a product to the catalog.
     *
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        productList.add(product);
    }

    /**
     * Retrieves a product from the catalog by its name.
     *
     * @param name The name of the product to retrieve.
     * @return The product with the specified name, or null if not found.
     */
    public Product getProductByName(String name) {
        for (Product product : productList) {
            if (product.getProductName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Retrieves all products in the catalog.
     *
     * @return A list containing all products in the catalog.
     */
    public List<Product> getAllproductList() {
        return productList;
    }

    /**
     * Adds a list of products to the catalog.
     *
     * @param newProductList The list of products to add.
     */
    public void addproductList(List<Product> newProductList) {
        productList.addAll(newProductList);
    }
}

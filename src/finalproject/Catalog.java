package finalproject;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Product> productList = new ArrayList<>();
    // Declaration of a private field "productList" of type List<Product> initialized with an ArrayList.

    public void addProduct(Product product) {
        // Declaration of a public method "addProduct" that takes a parameter of type Product.

        productList.add(product);
        // Adding the provided product to the list of productList.

    }

    public Product getProductByName(String name) {
        // Declaration of a public method "getProductByName" that takes a parameter of type String.

        for (Product product : productList) {
            // Starting a for-each loop to iterate over the productList in the list.

            if (product.getProductName().equals(name)) {
                // Checking if the name of the current product matches the provided name.

                return product;
                // Returning the product if a match is found.

            }

        }

        return null;
        // Returning null if no matching product is found.

    }

    public List<Product> getAllproductList() {
        // Declaration of a public method "getAllproductList" that returns a List<Product>.

        return productList;
        // Returning the list of all productList.

    }

    public void addproductList(List<Product> newproductList) {
        // Declaration of a public method "addproductList" that takes a parameter of type List<Product>.

        productList.addAll(newproductList);
        // Adding all the productList from the provided list to the existing list of productList.

    }
}

package finalproject;
// This line declares the package "thirdproject" for the current Java file.

import org.junit.Test;
// Importing the Test annotation from the JUnit framework.

import static org.junit.Assert.*;
// Importing static methods from the JUnit Assert class.

import java.util.ArrayList;
// Importing the ArrayList class from the java.util package.

import java.util.List;
// Importing the List interface from the java.util package.

public class CatalogTest {
// Declaration of a class named "CatalogTest" for testing the Catalog class.

    @Test
    // Annotation indicating that the following method is a test case.

    public void testAddProduct() {
        // Declaration of a test method named "testAddProduct".

        Catalog productCatalog = new Catalog();
        // Creating an instance of the Catalog class for testing.

        Product laptop = new ElectronicProduct("Laptop", 1200.0, "High-performance laptop", 10);
        // Creating an instance of the ElectronicProduct class for testing.

        productCatalog.addProduct(laptop);
        // Adding the laptop product to the productCatalog.

        assertEquals(1, productCatalog.getAllproductList().size());
        // Asserting that the productCatalog has one product after adding.

        assertEquals(laptop, productCatalog.getProductByName("Laptop"));
        // Asserting that the product retrieved by name is the same as the added laptop.

    }

    @Test
    // Annotation indicating that the following method is a test case.

    public void testAddProducts() {
        // Declaration of a test method named "testAddProducts".

        Catalog productCatalog = new Catalog();
        // Creating an instance of the Catalog class for testing.

        List<Product> newProducts = new ArrayList<>();
        // Creating a new list to hold productList.

        Product tShirt = new ClothingProduct("T-Shirt", 25.0, "Comfortable cotton T-shirt", 50);
        // Creating an instance of the ClothingProduct class for testing.

        newProducts.add(tShirt);
        // Adding the T-shirt product to the list.

        productCatalog.addproductList(newProducts);
        // Adding all productList from the list to the productCatalog.

        assertEquals(1, productCatalog.getAllproductList().size());
        // Asserting that the productCatalog has one product after adding.

        assertEquals(tShirt, productCatalog.getProductByName("T-Shirt"));
        // Asserting that the product retrieved by name is the same as the added T-shirt.

    }

    @Test
    // Annotation indicating that the following method is a test case.

    public void testGetProductByName() {
        // Declaration of a test method named "testGetProductByName".

        Catalog productCatalog = new Catalog();
        // Creating an instance of the Catalog class for testing.

        Product laptop = new ElectronicProduct("Laptop", 1200.0, "High-performance laptop", 10);
        // Creating an instance of the ElectronicProduct class for testing.

        productCatalog.addProduct(laptop);
        // Adding the laptop product to the productCatalog.

        assertEquals(laptop, productCatalog.getProductByName("Laptop"));
        // Asserting that the product retrieved by name is the same as the added laptop.

        assertNull(productCatalog.getProductByName("NonexistentProduct"));
        // Asserting that attempting to retrieve a nonexistent product returns null.

    }

    // Add more tests as needed

}

package finalproject;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Test class for the Catalog class.
 */
public class CatalogTest {

    /**
     * Test case for adding a product to the catalog.
     */
    @Test
    public void testAddProduct() {
        Catalog productCatalog = new Catalog();
        Product laptop = new ElectronicProduct("Laptop", 1200.0, "High-performance laptop", 10);
        productCatalog.addProduct(laptop);
        assertEquals(1, productCatalog.getAllproductList().size());
        assertEquals(laptop, productCatalog.getProductByName("Laptop"));
    }

    /**
     * Test case for adding multiple products to the catalog.
     */
    @Test
    public void testAddProducts() {
        Catalog productCatalog = new Catalog();
        List<Product> newProducts = new ArrayList<>();
        Product tShirt = new ClothingProduct("T-Shirt", 25.0, "Comfortable cotton T-shirt", 50);
        newProducts.add(tShirt);
        productCatalog.addproductList(newProducts);
        assertEquals(1, productCatalog.getAllproductList().size());
        assertEquals(tShirt, productCatalog.getProductByName("T-Shirt"));
    }

    /**
     * Test case for retrieving a product from the catalog by name.
     */
    @Test
    public void testGetProductByName() {
        Catalog productCatalog = new Catalog();
        Product laptop = new ElectronicProduct("Laptop", 1200.0, "High-performance laptop", 10);
        productCatalog.addProduct(laptop);
        assertEquals(laptop, productCatalog.getProductByName("Laptop"));
        assertNull(productCatalog.getProductByName("NonexistentProduct"));
    }
}

package finalproject;

/**
 * Implementation of the Product interface representing a clothing product.
 */
public class ClothingProduct implements Product {
    private String chosenProductName;
    private double productPrice;
    private String productDescription;
    private int productQuantityInStock;

    /**
     * Constructor to initialize a clothing product with provided details.
     *
     * @param chosenProductName     The name of the clothing product.
     * @param productPrice          The price of the clothing product.
     * @param productDescription    The description of the clothing product.
     * @param productQuantityInStock    The quantity of the clothing product in stock.
     */
    public ClothingProduct(String chosenProductName, double productPrice, String productDescription, int productQuantityInStock) {
        this.chosenProductName = chosenProductName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productQuantityInStock = productQuantityInStock;
    }

    @Override
    public String getProductName() {
        return chosenProductName;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public String getProductDescription() {
        return productDescription;
    }

    @Override
    public int getProductQuantityInStock() {
        return productQuantityInStock;
    }
}

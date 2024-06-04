package finalproject;

/**
 * Implementation of the Product interface representing an electronic product.
 */
public class ElectronicProduct implements Product {
    private String chosenProductName;
    private double productPrice;
    private String productDescription;
    private int productQuantityInStock;

    /**
     * Constructor to initialize an electronic product with provided details.
     *
     * @param chosenProductName     The name of the electronic product.
     * @param productPrice          The price of the electronic product.
     * @param productDescription    The description of the electronic product.
     * @param productQuantityInStock    The quantity of the electronic product in stock.
     */
    public ElectronicProduct(String chosenProductName, double productPrice, String productDescription, int productQuantityInStock) {
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

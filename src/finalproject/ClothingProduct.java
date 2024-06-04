package finalproject;

public class ClothingProduct implements Product {
    private String chosenProductName;
    private double productPrice;
    private String productDescription;
    private int productQuantityInStock;

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

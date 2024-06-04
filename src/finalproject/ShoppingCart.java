package finalproject;
import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
    private List<Product> productList = new ArrayList<>();
    public void addProduct(Product product) {
        productList.add(product);
    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double calculateTotalAmount() {
        double total = 0.0;
        for (Product product : productList) {
            total += product.getProductPrice();
        }
        return total;
    }
}

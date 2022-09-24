package staff.cashier;

import store.Store;
import store.product.Product;

public interface CashierInterface {
    Product getProduct (Store storeProducts, String productName);
    String getProductToSell(Product product, String productName);
    int extractYear(String year);
    String getProductYear(Product product);
    void sell(Store storeProducts, String productName); //Abstraction
}

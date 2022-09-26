package service;

import model.Cashier;
import model.Store;
import model.Product;

public interface CashierService {
    Product getProduct (Store storeProducts, String productName);
    String getProductToSell(Product product, String productName);
    int extractYear(String year);
    String getProductYear(Product product);
    String sell(Cashier cashier, Store storeProducts, String productName); //Abstraction
}

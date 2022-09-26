package service.impl;

import model.Cashier;
import model.Product;
import model.Store;
import service.CashierService;

import java.util.Calendar;

public class CashierServiceImpl implements CashierService {

    private int manufactureYear = 0;

    public int getManufactureYear() {
        return manufactureYear;
    }

    @Override
    public String sell(Cashier cashier, Store storeProducts, String productName) {
        Product product = getProduct(storeProducts, productName);
        String productToSell = getProductToSell(product, productName);

        if (productToSell != null) {
            int productYear = extractYear(getProductYear(product));
            manufactureYear = productYear;

            if (productYear >= cashier.getCustomer().getProductYear()) {
                cashier.setReceipt(String.valueOf(Calendar.getInstance().getTimeInMillis()));
                return "Thank you " + cashier.getCustomer().getName() + " for buying " + productToSell + ". Here is your receipt " + cashier.getReceipt() + ".";
            } else
                return cashier.getCustomer().getName() + ", we only have " + productToSell + " manufactured in " + productYear + ".";
        } else
            return cashier.getCustomer().getName() + ", your product request is not available in our storeProducts.";
    }

    @Override
    public Product getProduct(Store storeProducts, String productName) {
        for (Product product: storeProducts.getProducts()) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }

        return null;
    }

    @Override
    public String getProductToSell(Product product, String productName) {
        if (product == null) return null;
        if (product.getName().equals(productName)) {
            return product.getName();
        }

        return null;
    }

    @Override
    public int extractYear(String year) {
        year = year.substring(6);
        return Integer.parseInt(year);
    }

    @Override
    public String getProductYear(Product product) {
        return product.getManufactureDate();
    }
}

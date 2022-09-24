package staff.cashier;

import customer.Customer;
import staff.Staff;
import store.Store;
import store.product.Product;

import java.util.Calendar;
import java.util.List;

public class Cashier extends Staff implements CashierInterface { //Inheritance Staff Class

    private String receipt;

    private Customer customer; //Aggregation

    public Cashier(String name, String sex, int age, int id) {
        super(name, sex, age, id);
    }

    public Cashier() {

    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void sell(Store storeProducts, String productName) {
        Product product = getProduct(storeProducts, productName);
        String productToSell = getProductToSell(product, productName);

        if (productToSell != null) {
            int productYear = extractYear(getProductYear(product));

            if (productYear >= customer.getProductYear()) {
                setReceipt(String.valueOf(Calendar.getInstance().getTimeInMillis()));
                System.out.println("Thank you " + customer.getName() + " for buying " + productToSell + ". Here is your receipt " + getReceipt() + ".");
            } else
                System.out.println(customer.getName() + ", we only have " + productToSell + " manufactured in " + productYear + ".");
        } else
            System.out.println(customer.getName() + ", your product request is not available in our storeProducts.");
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

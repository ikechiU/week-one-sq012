package service.impl;

import model.Customer;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public String buy(Customer customer, String productName) {
        customer.setProductName(confirmProductName(productName));
        return "Hello cashier, I will like to buy " + customer.getProductName() + ".";
    }

    @Override
    public String buy(Customer customer, String productName, int year) {
        customer.setProductName(confirmProductName(productName));
        customer.setProductYear(year);
        return "Hello cashier, I will like to buy " + customer.getProductName() + ". That was manufactured in " + customer.getProductYear() +".";
    }

    @Override
    public String confirmProductName(String productName) {
        return String.valueOf(productName.charAt(0)).toUpperCase() + productName.substring(1).toLowerCase();
    }
}

package service;

import model.Customer;

public interface CustomerService {
    String buy(Customer customer, String productName); //Abstraction
    String buy(Customer customer, String productName, int year); //Method overloading
    String confirmProductName(String productName);
}

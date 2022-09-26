package service.impl;

import model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {

    @Test
    void buy() {
        Customer customer = new Customer("Henry", "Male", 43);
        Customer customer2 = new Customer("Angela", "Female", 21);

        CustomerServiceImpl customerService = new CustomerServiceImpl();

        String result = customerService.buy(customer, "BeAnS");
        String result1 = customerService.buy(customer2, "rIcE");

        assertEquals(result, "Hello cashier, I will like to buy " + customer.getProductName() + ".");
        assertEquals(result1, "Hello cashier, I will like to buy " + customer2.getProductName() + ".");
    }

    @Test
    void BuyOverLoaded() {
        Customer customer = new Customer("Henry", "Male", 43);
        Customer customer2 = new Customer("Angela", "Female", 21);

        CustomerServiceImpl customerService = new CustomerServiceImpl();

        String result = customerService.buy(customer, "BeAnS", 2022);
        String result1 = customerService.buy(customer2, "rIcE", 2033);

        assertEquals(result,
                "Hello cashier, I will like to buy " + customer.getProductName() + ". That was manufactured in " + customer.getProductYear() +".");
        assertEquals(result1,
                "Hello cashier, I will like to buy " + customer2.getProductName() + ". That was manufactured in " + customer2.getProductYear() +".");
    }

    @Test
    void confirmProductName() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        String productName = customerService.confirmProductName("BeANs");
        String productName1 = customerService.confirmProductName("RicE");
        String productName2 = customerService.confirmProductName("CAsHeW");
        assertEquals("Beans", productName);
        assertEquals("Rice", productName1);
        assertEquals("Cashew", productName2);
    }
}
package service.impl;

import model.Cashier;
import model.Customer;
import model.Product;
import model.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceImplTest {
    private final Store storeProducts = new StoreDBImpl().getStoreProducts();
    Customer customer = new Customer("Kendrick", "Female", 19);
    Customer customer2 = new Customer("Henry", "Male", 39);
    Customer customer3 = new Customer("Alex", "Male", 29);

    @Test
    void sell() {
        CashierServiceImpl cashierService = new CashierServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.buy(customer, "RiCe", 2022);
        customerService.buy(customer2, "Chicken", 2022);
        customerService.buy(customer3, "Beans", 2030);

        Cashier cashier = new Cashier();
        Cashier cashier2 = new Cashier();
        Cashier cashier3 = new Cashier();

        cashier.setCustomer(customer);
        cashier2.setCustomer(customer2);
        cashier3.setCustomer(customer3);

        String result = cashierService.sell(cashier, storeProducts, customer.getProductName());
        String receipt = cashier.getReceipt();

        String result2 = cashierService.sell(cashier2, storeProducts, customer2.getProductName());

        String result3 = cashierService.sell(cashier3, storeProducts, customer3.getProductName());
        String receipt3 = cashier.getReceipt();

        Assertions.assertEquals(
                result,
                "Thank you " + cashier.getCustomer().getName() + " for buying " + cashier.getCustomer().getProductName() + ". Here is your receipt " + receipt + "."
        );

        Assertions.assertEquals(result2, cashier2.getCustomer().getName() + ", your product request is not available in our storeProducts.");

        Assertions.assertEquals(
                result3,
                cashier3.getCustomer().getName() + ", we only have " + cashier3.getCustomer().getProductName() + " manufactured in " + cashierService.getManufactureYear() + "."
        );
    }

    @Test
    void getProduct() {
        Product product = storeProducts.getProducts().get(0);
        Product product1 = storeProducts.getProducts().get(1);

        Product product2 = null;
        for (Product aProduct : storeProducts.getProducts()) {
            if (aProduct.getName().equals("Rice")) {
                product2 = aProduct;
            }
        }

        Product product3 = null;
        for (Product aProduct : storeProducts.getProducts()) {
            if (aProduct.getName().equals("Cashew")) {
                product3 = aProduct;
            }
        }

        assertEquals(product, product2);
        assertNotEquals(product1, product2);
        assertNull(product3);
    }

    @Test
    void getProductToSell() {
        CashierServiceImpl cashierService = new CashierServiceImpl();
        Product product = null;
        for (Product aProduct : storeProducts.getProducts()) {
            if (aProduct.getName().equals("Carrot")) {
                product = aProduct;
            }
        }
        assertEquals("Carrot", cashierService.getProductToSell(product, "Carrot"));
        assertNull(cashierService.getProductToSell(product, ""));
        assertNotEquals("Coke", cashierService.getProductToSell(product, "Carrot"));
        assertNull(cashierService.getProductToSell(product, null));
    }

    @Test
    void extractYear() {
        CashierServiceImpl cashierService = new CashierServiceImpl();
        String year = "02-02-2020";
        String year1 = "02-02-2023";
        String year2 = "02-02-2024";

        assertEquals("2020", String.valueOf(cashierService.extractYear(year)));
        assertEquals("2023", String.valueOf(cashierService.extractYear(year1)));
        assertEquals("2024", String.valueOf(cashierService.extractYear(year2)));

        String year3 = null;
        for (Product aProduct: storeProducts.getProducts()) {
            if (aProduct.getName().equals("Carrot")) {
                year3 = aProduct.getManufactureDate();
            }
        }
        assertEquals("2030", String.valueOf(cashierService.extractYear(year3)));
    }

    @Test
    void getProductYear() {
        CashierServiceImpl cashierService = new CashierServiceImpl();
        Product product = storeProducts.getProducts().get(0);
        Product product1 = storeProducts.getProducts().get(1);
        Product product2 = storeProducts.getProducts().get(2);
        assertEquals("02-02-2022", cashierService.getProductYear(product));
        assertEquals("02-02-2023", cashierService.getProductYear(product1));
        assertEquals("02-02-2024", cashierService.getProductYear(product2));
    }
}
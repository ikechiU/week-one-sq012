package staff.cashier;

import customer.Customer;
import org.junit.jupiter.api.Test;
import store.Store;
import store.StoreDB;
import store.product.Product;
import store.product.ProductsDB;

import java.util.Calendar;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

class CashierTest {
    private final Store storeProducts = new StoreDB().getStoreProducts();
    CashierImpl cashier = new CashierImpl();
    Customer customer = new Customer("Kendrick", "Female", 19);

    @Test
    void getReceipt() {
        String receipt = (String.valueOf(Calendar.getInstance().getTimeInMillis()));
        cashier.setReceipt(receipt);
        assertEquals(receipt, cashier.getReceipt());
    }

    @Test
    void getCustomer() {
        cashier.setCustomer(customer);
        assertEquals("Kendrick", cashier.getCustomer().getName());
        assertEquals("Female", cashier.getCustomer().getSex());
        assertEquals(19, cashier.getCustomer().getAge());
    }

    @Test
    void sell_product_name_correct() {
        cashier.setCustomer(customer);
        cashier.sell(storeProducts, "Rice");
    }

    @Test
    void sell_product_name_not_correct() {
        cashier.setCustomer(customer);
        cashier.sell(storeProducts, "maggi");
    }


    @Test
    void sell_product_name_year_correct() {
        customer.buy("Rice", 2022);
        cashier.setCustomer(customer);
        cashier.sell(storeProducts, "Rice");
    }

    @Test
    void sell_product_name_year_not_correct() {
        customer.buy("Rice", 2025);
        cashier.setCustomer(customer);
        cashier.sell(storeProducts, "maggi");
    }

    @Test
    void getProduct() {
        Product product = storeProducts.getProducts().get(0);
        Product product1 = storeProducts.getProducts().get(1);

        Product product2 = null;
        for (Product aProduct: storeProducts.getProducts()) {
            if (aProduct.getName().equals("Rice")) {
                product2 = aProduct;
            }
        }

        Product product3 = null;
        for (Product aProduct: storeProducts.getProducts()) {
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
        Product product = null;
        for (Product aProduct: storeProducts.getProducts()) {
            if (aProduct.getName().equals("Carrot")) {
                product = aProduct;
            }
        }
        assertEquals("Carrot", cashier.getProductToSell(product, "Carrot"));
        assertNull(cashier.getProductToSell(product, ""));
        assertNotEquals("Coke", cashier.getProductToSell(product, "Carrot"));
        assertNull(cashier.getProductToSell(product, null));
    }

    @Test
    void extractYear() {
        String year = "02-02-2020";
        String year1 = "02-02-2023";
        String year2 = "02-02-2024";

        assertEquals("2020", String.valueOf(cashier.extractYear(year)));
        assertEquals("2023", String.valueOf(cashier.extractYear(year1)));
        assertEquals("2024", String.valueOf(cashier.extractYear(year2)));

        String year3 = null;
        for (Product aProduct: storeProducts.getProducts()) {
            if (aProduct.getName().equals("Carrot")) {
                year3 = aProduct.getManufactureDate();
            }
        }
        assertEquals("2030", String.valueOf(cashier.extractYear(year3)));
    }

    @Test
    void getProductYear() {
        Product product = storeProducts.getProducts().get(0);
        Product product1 = storeProducts.getProducts().get(1);
        Product product2 = storeProducts.getProducts().get(2);
        assertEquals("02-02-2022", cashier.getProductYear(product));
        assertEquals("02-02-2023", cashier.getProductYear(product1));
        assertEquals("02-02-2024", cashier.getProductYear(product2));
    }

}
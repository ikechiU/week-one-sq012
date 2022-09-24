package customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private final CustomerImpl customer = new CustomerImpl();

    @Test
    void buy() {
        System.out.println("productName \"BeANs\" is corrected.");
        customer.buy("BeANs");
    }

    @Test
    void confirmProductName() {
        String productName = customer.confirmProductName("BeANs");
        assertEquals("Beans", productName);
    }

    @Test
    void getProductName() {
        customer.setProductName(customer.confirmProductName("BEaNS"));
        assertEquals("Beans", customer.getProductName());
    }

    @Test
    void getProductYear() {
        customer.setProductYear(2000);
        assertEquals(2000, customer.getProductYear());
    }
}
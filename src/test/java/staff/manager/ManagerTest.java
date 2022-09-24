package staff.manager;

import org.junit.jupiter.api.Test;
import staff.Staff;
import staff.cashier.Cashier;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private final Staff cashier = new Cashier("Marcus", "Male", 41, 90); //Polymorphism
    private final Cashier cashier2 = new Cashier("Frederica", "Female", 39, 95);
    private final ManagerImpl manager = new ManagerImpl();

    @Test
    void hireCashier() {
        assertEquals("Frederica", cashier2.getName());
        assertEquals("Marcus", cashier.getName());
        assertNotEquals("Marcus", null);
        assertEquals(95, cashier2.getId());
        assertEquals(39, cashier2.getAge());

        manager.hireCashier((Cashier) cashier);
        manager.hireCashier(cashier2);
    }
}
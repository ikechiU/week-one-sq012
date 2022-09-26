package service.impl;

import model.Cashier;
import model.Staff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceImplTest {

    @Test
    void hireCashier() {
        Staff cashier = new Cashier("Marcus", "Male", 41, 90); //Polymorphism
        Cashier cashier2 = new Cashier("Frederica", "Female", 39, 95);
        ManagerServiceImpl managerService = new ManagerServiceImpl();

        assertEquals("Frederica", cashier2.getName());
        assertEquals("Marcus", cashier.getName());
        assertNotEquals("Marcus", null);
        assertEquals(95, cashier2.getId());
        assertEquals(39, cashier2.getAge());

        managerService.hireCashier((Cashier) cashier);
        managerService.hireCashier(cashier2);

    }
}
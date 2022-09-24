package staff.manager;

import staff.Staff;
import staff.cashier.Cashier;

public class Manager extends Staff implements ManagerInterface{ //Inheritance Staff Class

    public Manager(String name, String sex, int age, int id) {
        super(name, sex, age, id);
    }

    public Manager() {

    }

    @Override
    public void hireCashier(Cashier cashier) {
        System.out.println(cashier.getName() + ", you have been hired as a cashier. Your ID is " + cashier.getId() + ".");
    }
}

package staff.manager;

import staff.cashier.Cashier;

public class ManagerImpl implements ManagerInterface{

    @Override
    public void hireCashier(Cashier cashier) {
        System.out.println(cashier.getName() + ", you have been hired as a cashier. Your ID is " + cashier.getId() + ".");
    }
}

package service.impl;

import model.Cashier;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    @Override
    public String hireCashier(Cashier cashier) {
        return cashier.getName() + ", you have been hired as a cashier. Your ID is " + cashier.getId() + ".";
    }
}

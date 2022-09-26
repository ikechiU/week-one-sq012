import model.Customer;
import model.Staff;
import model.Cashier;
import model.Manager;
import model.Store;
import service.impl.CashierServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.ManagerServiceImpl;
import service.impl.StoreDBImpl;

import java.util.spi.CalendarDataProvider;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("Michael", "Male", 32, 1);
        Staff cashier = new Cashier("Doris", "Female", 25, 2); //Polymorphism
        Cashier cashier2 = new Cashier("Smith", "Male", 28, 10);
        Customer customer = new Customer("Henry", "Male", 43);
        Customer customer2 = new Customer("Angela", "Female", 21);
        Customer customer3 = new Customer("Agatha", "Female", 30);
        Customer customer4 = new Customer("Herschel", "Male", 50);

        ManagerServiceImpl managerService = new ManagerServiceImpl();
        CashierServiceImpl cashierService = new CashierServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        StoreDBImpl storeDB = new StoreDBImpl();

        Store storeProducts = storeDB.getStoreProducts();



        String cashierHireResult = managerService.hireCashier((Cashier) cashier); //Casting
        System.out.println(cashierHireResult + "\n");

        String customerBuyResult = customerService.buy(customer, "RICE");
        System.out.println(customerBuyResult + "\n");

        ((Cashier) cashier).setCustomer(customer);
        String cashierSellResult = cashierService.sell((Cashier) cashier, storeProducts, customer.getProductName());
        System.out.println(cashierSellResult + "\n");

        String customer2BuyResult = customerService.buy(customer2, "beankS");
        System.out.println(customer2BuyResult + "\n");

        ((Cashier) cashier).setCustomer(customer2);
        String cashier2SellResult = cashierService.sell((Cashier) cashier, storeProducts, customer2.getProductName());
        System.out.println(cashier2SellResult + "\n");

        String customer3BuyResult = customerService.buy(customer3, "RICE", 2022);
        System.out.println(customer3BuyResult + "\n");

        cashier2.setCustomer(customer3);
        String cashier3SellResult = cashierService.sell(cashier2, storeProducts, customer3.getProductName());
        System.out.println(cashier3SellResult + "\n");

        String customer4BuyResult = customerService.buy(customer4, "bEaNs", 2025);
        System.out.println(customer4BuyResult + "\n");

        cashier2.setCustomer(customer4);
        String cashier4SellResult = cashierService.sell(cashier2, storeProducts, customer4.getProductName());
        System.out.println(cashier4SellResult + "\n");

    }
}

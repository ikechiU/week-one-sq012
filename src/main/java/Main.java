import customer.Customer;
import staff.Staff;
import staff.cashier.Cashier;
import staff.cashier.CashierInterface;
import staff.manager.Manager;
import store.Store;
import store.StoreDB;
import store.product.Product;
import store.product.ProductsDB;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Store storeProducts = new StoreDB().getStoreProducts();

        Manager manager = new Manager("Michael", "Male", 32, 1);
        Staff cashier = new Cashier("Doris", "Female", 25, 2); //Polymorphism
        Cashier cashier2 = new Cashier("Smith", "Male", 28, 10);
        Customer customer = new Customer("Henry", "Male", 43);
        Customer customer2 = new Customer("Angela", "Female", 21);
        Customer customer3 = new Customer("Agatha", "Female", 30);
        Customer customer4 = new Customer("Herschel", "Male", 50);

        manager.hireCashier((Cashier) cashier); //Casting
        System.out.println("");

        customer.buy("RICE");
        ((Cashier) cashier).setCustomer(customer);
        ((Cashier) cashier).sell(storeProducts, customer.getProductName());

        System.out.println("");

        customer2.buy("beankS");
        ((Cashier) cashier).setCustomer(customer2);
        ((Cashier) cashier).sell(storeProducts, customer2.getProductName());

        System.out.println("");

        customer3.buy("rIcE", 2022);
        cashier2.setCustomer(customer3);
        cashier2.sell(storeProducts, customer3.getProductName());

        System.out.println("");

        customer4.buy("bEaNs", 2025);
        cashier2.setCustomer(customer4);
        cashier2.sell(storeProducts, customer4.getProductName());
    }
}

package store.product;

import java.util.ArrayList;
import java.util.List;

public class ProductsDB {
    public List<Product> getProducts() {
        Product product1 = new Product("Rice", "02-02-2022", "02-02-2023");
        Product product2 = new Product("Beans", "02-02-2023", "02-02-2024");
        Product product3 = new Product("Milk", "02-02-2024", "02-02-2025");
        Product product4 = new Product("Egg", "02-02-2025", "02-02-2026");
        Product product5 = new Product("Bread", "02-02-2026", "02-02-2027");
        Product product6 = new Product("Coke", "02-02-2027", "02-02-2028");
        Product product7 = new Product("Fish", "02-02-2028", "02-02-2029");
        Product product8 = new Product("Tomato", "02-02-2029", "02-02-2030");
        Product product9 = new Product("Carrot", "02-02-2030", "02-02-2031");
        Product product10 = new Product("Floor", "02-02-2031", "02-02-2032");

        List<Product> returnValue = new ArrayList<>();
        returnValue.add(product1);
        returnValue.add(product2);
        returnValue.add(product3);
        returnValue.add(product4);
        returnValue.add(product5);
        returnValue.add(product6);
        returnValue.add(product7);
        returnValue.add(product8);
        returnValue.add(product9);
        returnValue.add(product10);

        return returnValue;
    }
}

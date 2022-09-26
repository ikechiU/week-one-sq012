package service.impl;

import model.Product;
import model.Store;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductsDBImplTest {

    @Test
    void getProducts() {
        StoreDBImpl storeDB = new StoreDBImpl();
        Store store = storeDB.getStoreProducts();

        List<Product> products = store.getProducts();
        assertEquals(products.get(0).getName(), "Rice");
    }
}
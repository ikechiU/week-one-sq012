package store;

import store.product.ProductsDB;

public class StoreDB {
    public Store getStoreProducts() {
        ProductsDB productsDB = new ProductsDB();
        return new Store(productsDB.getProducts());
    }
}

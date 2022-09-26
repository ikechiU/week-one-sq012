package service.impl;

import model.Store;
import service.StoreDBService;

public class StoreDBImpl implements StoreDBService {
    @Override
    public Store getStoreProducts() {
        ProductsDBImpl productsDBImpl = new ProductsDBImpl();
        return new Store(productsDBImpl.getProducts());
    }
}

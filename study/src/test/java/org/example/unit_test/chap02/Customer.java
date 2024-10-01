package org.example.unit_test.chap02;

public class Customer {

    public boolean purchase(final Store store, final Product product, final int quantity) {
        if (store.getInventory(product) >= quantity) {
            store.addInventory(product, -quantity);
            return true;
        }
        return false;
    }

}

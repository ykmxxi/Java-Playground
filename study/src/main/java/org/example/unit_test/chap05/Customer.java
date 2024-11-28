package org.example.unit_test.chap05;

public class Customer {

    private Long id;

    public Customer(final long id) {
        this.id = id;
    }

    public boolean purchase(final Store store, final Product product, final int quantity) {
        if (store.hasEnoughInventory(product, quantity)) {
            store.removeInventory(product, quantity);
            return true;
        }
        return false;
    }

}

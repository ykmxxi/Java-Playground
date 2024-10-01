package org.example.unit_test.chap02;

import java.util.HashMap;
import java.util.Map;

public class Store {

    private final Map<Product, Integer> inventories = new HashMap<Product, Integer>();

    public void addInventory(final Product product, final int quantity) {
        inventories.put(product, inventories.getOrDefault(product, 0) + quantity);
    }

    public int getInventory(final Product product) {
        return inventories.getOrDefault(product, 0);
    }

}

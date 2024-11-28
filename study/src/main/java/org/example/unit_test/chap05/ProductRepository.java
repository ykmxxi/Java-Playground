package org.example.unit_test.chap05;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();

    public ProductRepository() {
        products.put(1L, new Product("Shampoo"));
    }

    Product findById(final Long id) {
        if (products.containsKey(id)) {
            return products.get(id);
        }
        return null;
    }

}

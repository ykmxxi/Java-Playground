package org.example.unit_test.chap06;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(final Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products.stream()
                .toList();
    }

}

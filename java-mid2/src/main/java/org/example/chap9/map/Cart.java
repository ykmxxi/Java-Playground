package org.example.chap9.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {

    private final Map<Product, Integer> carts = new HashMap<>();

    public void add(final Product product, final int quantity) {
        carts.put(product, carts.getOrDefault(product, 0) + quantity);
    }

    public void minus(final Product product, final int quantity) {
        int existQuantity = carts.getOrDefault(product, 0);

        if (newQuantity(existQuantity, quantity) <= 0) {
            carts.remove(product);
        } else {
            carts.put(product, newQuantity(existQuantity, quantity));
        }
    }

    private int newQuantity(final int existQuantity, final int quantity) {
        return existQuantity - quantity;
    }

    public void printAll() {
        System.out.println("==모든 상품 출력==");
        for (Entry<Product, Integer> entry : carts.entrySet()) {
            System.out.println("상품: " + entry.getKey() + ", 수량: " + entry.getValue());
        }
    }

}

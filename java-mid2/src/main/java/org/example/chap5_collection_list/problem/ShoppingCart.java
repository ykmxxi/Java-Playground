package org.example.chap5_collection_list.problem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(final Item item) {
        items.add(item);
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");

        for (Item item : items) {
            System.out.println("상품명:" + item.getName() + ", 합계:" + item.getTotalPrice());
        }

        System.out.println("전체 가격 합:" + getTotalPrice());
    }

    private int getTotalPrice() {
        return items.stream()
                .mapToInt(Item::getTotalPrice)
                .sum();
    }

}

package org.example.chap5_collection_list.problem;

public class Item {

    private final String name;
    private final int price;
    private final int quantity;

    public Item(final String name, final int price, final int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

}

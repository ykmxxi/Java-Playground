package chap6.problem;

public class Item {

    private final String itemName;
    private final int price;
    private final int quantity;

    public Item(final String itemName, final int price, final int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

}

package chap9.problem.item;

public class Item {

    private final String name;
    private int price;

    public Item(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println("이름 : " + name + ", 가격 : " + price);
    }

    public int getPrice() {
        return price;
    }

}

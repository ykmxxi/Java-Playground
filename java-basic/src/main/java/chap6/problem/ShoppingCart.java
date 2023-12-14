package chap6.problem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Item> items = new ArrayList<>();
    private int itemCount;

    public void addItem(final Item item) {
        if (itemCount >= 10) {
            System.out.println("장바구니가 가득 찼습니다.");
        }
        items.add(item);
        itemCount++;
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        for (Item item : items) {
            System.out.println("상품명:" + item.getItemName() + ", 합계:" + item.getTotalPrice());
        }
        System.out.println("전체 가격 합:" + calculateTotalPrice());
    }

    private int calculateTotalPrice() {
        return items.stream()
                .mapToInt(Item::getTotalPrice)
                .sum();
    }

}

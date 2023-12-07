package chap1.problem;

public class ProductOrder {

    private final String productName;
    private final int price;
    private final int quantity;

    public ProductOrder(final String productName, final int price, final int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getOrderDetail() {
        return "상품명: " + productName + ", 가격:" + price + ", 수량: " + quantity;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

}

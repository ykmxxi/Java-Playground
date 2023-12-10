package chap2.problem;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderMain {

    public static void main(String[] args) {
        List<ProductOrder> orders = new ArrayList<>();

        orders.add(createOrder("두부", 2000, 2));
        orders.add(createOrder("김치", 5000, 1));
        orders.add(createOrder("콜라", 1500, 2));

        printOrders(orders);

        System.out.println("총 결제 금액: " + getTotalAmount(orders));
    }

    private static ProductOrder createOrder(final String productName, final int price, final int quantity) {
        return new ProductOrder(productName, price, quantity);
    }

    private static void printOrders(final List<ProductOrder> orders) {
        orders.forEach(order ->
                System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity)
        );
    }

    private static int getTotalAmount(final List<ProductOrder> orders) {
        return orders.stream()
                .mapToInt(order -> order.price * order.quantity)
                .sum();
    }

}

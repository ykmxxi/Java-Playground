package chap2.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductOrderMain2 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int size = scanner.nextInt();
        List<ProductOrder> orders = new ArrayList<>(size);
        scanner.nextLine(); // 입력 버퍼를 비우기 위한 코드

        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + "번째 주문 정보를 입력하세요.");
            System.out.print("상품명: ");
            String productName = scanner.nextLine();
            System.out.print("가격: ");
            int price = scanner.nextInt();
            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // 입력 버퍼를 비우기 위한 코드

            orders.add(createOrder(productName, price, quantity));
        }

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

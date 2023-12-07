package chap1.problem;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderMain {

    public static void main(String[] args) {
        List<ProductOrder> orders = new ArrayList<>();

        ProductOrder order1 = new ProductOrder("두부", 2000, 2);
        orders.add(order1);
        ProductOrder order2 = new ProductOrder("김치", 5000, 1);
        orders.add(order2);
        ProductOrder order3 = new ProductOrder("콜라", 1500, 2);
        orders.add(order3);

        int totalAmount = 0;
        for (ProductOrder order : orders) {
            System.out.println(order.getOrderDetail());
            totalAmount += order.getTotalPrice();
        }

        System.out.println("총 결제 금액: " + totalAmount);

    }

}

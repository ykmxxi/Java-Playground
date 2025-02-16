package org.example.test;

import java.time.LocalDateTime;

public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    public void discount(final Long orderId) {
        LocalDateTime orderDateTime = LocalDateTime.now();
        double discount = orderService.discountWith(orderId, orderDateTime);
        System.out.println("할인적용 후 금액 = " + discount);
    }

}

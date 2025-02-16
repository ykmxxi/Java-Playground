package org.example.test;

import java.time.LocalDateTime;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public double discountWith(final Long orderId, final LocalDateTime orderDateTime) {
        Order order = orderRepository.findById(orderId);
        return order.discount(orderDateTime.getDayOfWeek());
    }

}

package org.example.executor.problem;

public class NewOrderServiceTestMain {

    public static void main(String[] args) {
        String orderNo = "Order#1234"; // 예시 주문 번호
        NewOrderService orderService = new NewOrderService();
        orderService.order(orderNo);
        // 1초 조금 넘게 걸림
    }

}

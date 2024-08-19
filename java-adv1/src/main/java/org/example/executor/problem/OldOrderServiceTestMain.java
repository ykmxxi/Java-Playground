package org.example.executor.problem;

public class OldOrderServiceTestMain {

    public static void main(String[] args) {
        String orderNo = "Order#1234"; // 예시 주문 번호
        OldOrderService orderService = new OldOrderService();
        orderService.order(orderNo);
        // 총 실행 시간 3초
    }

}

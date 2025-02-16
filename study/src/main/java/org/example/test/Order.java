package org.example.test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Order {

    private int id;
    private int amount = 1_000;
    private String status;
    private LocalDateTime orderDateTime;
    private String description;
    private int parentId;

    public double discountBad() {
        // 제어할 수 없는 값이 비즈니스 로직에 존재 -> 테스트가 어려움
        LocalDateTime now = LocalDateTime.now();

        if (now.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            return amount * 0.9;
        }
        return amount;
    }

    public double discount(final DayOfWeek orderDayOfWeek) {
        // 제어할 수 없는 요소를 파라미터로 받는다 -> 비즈니스 로직 외부에서 제어할 수 없는 값을 주입받는다
        if (orderDayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return amount * 0.9;
        }
        return amount;
    }

    public void orderCancelBad(final LocalDateTime cancelDateTime) {
        if (orderDateTime.isAfter(cancelDateTime)) {
            throw new IllegalArgumentException("주문 시간이 주문 취소 시간보다 늦을 수 없습니다.");
        }
        // Active Record 패턴
        Order cancelOrder = new Order();
        cancelOrder.amount = this.amount * -1;
        cancelOrder.status = "cancel";
        cancelOrder.orderDateTime = cancelDateTime;
        cancelOrder.description = this.description;
        cancelOrder.parentId = this.id;

        // 의도한대로 취소 주문이 생성되었는지 확인하기 위해서는 항상 DB가 필요
        saveCancelOrder(cancelOrder);
    }

    public Order orderCancel(final LocalDateTime cancelDateTime) {
        if (orderDateTime.isAfter(cancelDateTime)) {
            throw new IllegalArgumentException("주문 시간이 주문 취소 시간보다 늦을 수 없습니다.");
        }
        // Active Record 패턴
        Order cancelOrder = new Order();
        cancelOrder.amount = this.amount * -1;
        cancelOrder.status = "cancel";
        cancelOrder.orderDateTime = cancelDateTime;
        cancelOrder.description = this.description;
        cancelOrder.parentId = this.id;
        return cancelOrder;
    }

    private void saveCancelOrder(final Order cancelOrder) {
        // DB Connection
        // repository.save(cancelOrder);
    }

}

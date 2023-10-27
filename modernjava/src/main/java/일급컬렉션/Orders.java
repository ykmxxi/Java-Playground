package 일급컬렉션;

import java.util.List;

class Order {

    private final long amount;

    public Order(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

}

public class Orders {

    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public long getTotalAmount() {
        return orders.stream()
                     .mapToLong(Order::getAmount)
                     .sum();
    }

}

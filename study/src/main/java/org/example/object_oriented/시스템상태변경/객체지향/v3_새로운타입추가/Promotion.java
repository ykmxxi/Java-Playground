package org.example.object_oriented.시스템상태변경.객체지향.v3_새로운타입추가;

public class Promotion {

    private Cart cart;
    private DiscountCondition condition;

    public void apply(Cart cart) {
        if (condition.isApplicableTo(cart)) {
            this.cart = cart;
        }
    }

}

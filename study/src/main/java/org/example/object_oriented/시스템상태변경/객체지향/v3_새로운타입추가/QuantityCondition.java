package org.example.object_oriented.시스템상태변경.객체지향.v3_새로운타입추가;

public class QuantityCondition implements DiscountCondition {

    private int baseQuantity;

    @Override
    public boolean isApplicableTo(final Cart cart) {
        return cart.getTotalQuantity() >= baseQuantity;
    }
    
}

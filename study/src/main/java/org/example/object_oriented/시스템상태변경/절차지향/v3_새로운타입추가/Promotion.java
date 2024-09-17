package org.example.object_oriented.시스템상태변경.절차지향.v3_새로운타입추가;

// 새로운 타입 추가: 데이터 클래스의 코드가 변경
public class Promotion {

    public enum ConditionType {
        PRICE, QUANTITY;
    }

    private Long cartId;
    private Long basePrice;
    private int baseQuantity;
    private ConditionType conditionType;

    public Long getBasePrice() {
        return basePrice;
    }

    public int getBaseQuantity() {
        return baseQuantity;
    }

    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setCart(final Cart cart) {
        this.cartId = cart.getCartId();
    }

}

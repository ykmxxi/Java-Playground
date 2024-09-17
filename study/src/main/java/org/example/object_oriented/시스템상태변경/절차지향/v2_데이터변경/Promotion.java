package org.example.object_oriented.시스템상태변경.절차지향.v2_데이터변경;

// 데이터 변경: 데이터 클래스의 코드가 변경
public class Promotion {

    private Long cartId;
    private Long minimumPrice;
    private Long maximumPrice;

    public Long getMinimumPrice() {
        return minimumPrice;
    }

    public Long getMaximumPrice() {
        return maximumPrice;
    }

    public void setCart(final Cart cart) {
        this.cartId = cart.getCartId();
    }

}

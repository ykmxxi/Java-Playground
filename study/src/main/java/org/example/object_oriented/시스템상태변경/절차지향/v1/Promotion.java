package org.example.object_oriented.시스템상태변경.절차지향.v1;

public class Promotion {

    private Long cartId;
    private Long basePrice;

    public Long getBasePrice() {
        return basePrice;
    }

    public void setCart(final Cart cart) {
        this.cartId = cart.getCartId();
    }

}

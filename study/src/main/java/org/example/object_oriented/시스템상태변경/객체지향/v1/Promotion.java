package org.example.object_oriented.시스템상태변경.객체지향.v1;

import org.example.object_oriented.시스템상태변경.절차지향.v1.Cart;

public class Promotion {

    private Cart cart;
    private Long basePrice;

    public void apply(Cart cart) {
        if (cart.getTotalPrice() >= basePrice) {
            this.cart = cart;
        }
    }

}

package org.example.object_oriented.시스템상태변경.객체지향.v2_데이터변경;

import org.example.object_oriented.시스템상태변경.절차지향.v1.Cart;

// 데이터 변경: 프로모션 적용 로직의 기준이 변경된다
public class Promotion {

    private Cart cart;
    private Long minimumPrice;
    private Long maximumPrice;

    public void apply(Cart cart) {
        Long totalPrice = cart.getTotalPrice();
        if (minimumPrice <= totalPrice && totalPrice <= maximumPrice) {
            this.cart = cart;
        }
    }

}

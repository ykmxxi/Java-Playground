package org.example.object_oriented.시스템상태변경.절차지향.v1;

public class PromotionProcess {

    public void apply(Promotion promotion, Cart cart) {
        if (isApplicableTo(promotion, cart)) {
            promotion.setCart(cart);
        }
    }

    private boolean isApplicableTo(Promotion promotion, Cart cart) {
        return cart.getTotalPrice() >= promotion.getBasePrice();
    }

}

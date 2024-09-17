package org.example.object_oriented.시스템상태변경.절차지향.v2_데이터변경;

// 데이터 변경: 데이터를 사용하는 프로세스의 코드도 변경
public class PromotionProcess {

    public void apply(Promotion promotion, Cart cart) {
        if (isApplicableTo(promotion, cart)) {
            promotion.setCart(cart);
        }
    }

    // 데이터를 사용하는 할인 로직도 변경
    private boolean isApplicableTo(Promotion promotion, Cart cart) {
        Long totalPrice = cart.getTotalPrice();
        return promotion.getMinimumPrice() <= totalPrice && totalPrice <= promotion.getMaximumPrice();
    }

}

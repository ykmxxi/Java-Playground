package org.example.object_oriented.시스템상태변경.절차지향.v3_새로운타입추가;

// 새로운 타입 추가: 데이터를 사용하는 프로세스의 코드도 변경
public class PromotionProcess {

    public void apply(Promotion promotion, Cart cart) {
        if (isApplicableTo(promotion, cart)) {
            promotion.setCart(cart);
        }
    }

    private boolean isApplicableTo(Promotion promotion, Cart cart) {
        switch (promotion.getConditionType()) {
            case PRICE -> {
                cart.getTotalPrice();
            }
            case QUANTITY -> {
                cart.getTotalQuantity();
            }
        }
        return false;
    }

}

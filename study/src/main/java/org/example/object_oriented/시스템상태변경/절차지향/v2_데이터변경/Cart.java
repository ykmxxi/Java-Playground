package org.example.object_oriented.시스템상태변경.절차지향.v2_데이터변경;

import java.util.ArrayList;
import java.util.List;

import org.example.object_oriented.CartLineItem;

public class Cart {

    private Long cartId;
    private List<CartLineItem> items = new ArrayList<>();

    public Long getTotalPrice() {
        return items.stream().mapToLong(CartLineItem::getPrice).sum();
    }

    public int getTotalQuantity() {
        return items.stream().mapToInt(CartLineItem::getQuantity).sum();
    }

    public Long getCartId() {
        return cartId;
    }

}

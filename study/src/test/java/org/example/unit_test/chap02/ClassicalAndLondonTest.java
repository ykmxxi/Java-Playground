package org.example.unit_test.chap02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.unit_test.chap02.Product.SHAMPOO;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ClassicalAndLondonTest {

    // 고전파(Classical Style): 준비 실행 검증 패턴(Arrange Act Assert, AAA)
    // 협력자의 상태 검증
    @Test
    @DisplayName("고전파 스타일 고객 구매 성공")
    void classicalPurchaseSuccessWhenEnoughInventory() {
        // 준비
        var store = new Store(); // collaborator
        var customer = new Customer(); // SUT
        store.addInventory(SHAMPOO, 10);

        // 실행
        boolean result = customer.purchase(store, SHAMPOO, 5);

        // 검증
        assertThat(result).isTrue();
        assertThat(store.getInventory(SHAMPOO)).isEqualTo(5);
    }

    @Test
    @DisplayName("고전파 스타일 고객 구매 실패")
    void classicalPurchaseFailWhenNotEnoughInventory() {
        // 준비
        var store = new Store(); // collaborator
        var customer = new Customer(); // SUT
        store.addInventory(SHAMPOO, 10);

        // 실행
        boolean result = customer.purchase(store, SHAMPOO, 15);

        // 검증
        assertThat(result).isFalse();
        assertThat(store.getInventory(SHAMPOO)).isEqualTo(10);
    }

    // 런던파 스타일: SUT의 협력자를 Mock로 대체, Mockito 라이브러리 사용
    // SUT와 협력자 간의 상호 작용 검증
    @Test
    @DisplayName("런던파 스타일 고객 구매 성공")
    void londonPurchaseSuccessWhenEnoughInventory() {
        // 준비
        Store store = Mockito.mock(Store.class); // Store 협력자를 Mock 객체로 만듬
        // 협력자의 동작을 설정 (Mock 동작 정의)
        when(store.getInventory(SHAMPOO)).thenReturn(10); // 샴푸 재고 10개
        doNothing().when(store).addInventory(SHAMPOO, -5); // 샴푸 5개 제거

        Customer customer = new Customer(); // SUT

        // 실행
        boolean result = customer.purchase(store, SHAMPOO, 5);

        // 검증
        assertThat(result).isTrue();
        verify(store).getInventory(SHAMPOO);
        verify(store).addInventory(SHAMPOO, -5);
    }

    @Test
    @DisplayName("런던파 스타일 고객 구매 실패")
    void londonPurchaseFailWhenNotEnoughInventory() {
        // 준비
        Store store = Mockito.mock(Store.class); // Store 협력자를 Mock 객체로 만듬
        // 협력자의 동작을 설정 (Mock 동작 정의)
        when(store.getInventory(SHAMPOO)).thenReturn(10); // 샴푸 재고 10개

        Customer customer = new Customer(); // SUT

        // 실행
        boolean result = customer.purchase(store, SHAMPOO, 15);

        // 검증
        assertThat(result).isFalse();
        verify(store).getInventory(SHAMPOO);
        verify(store, never()).addInventory(any(Product.class), anyInt());
    }

}

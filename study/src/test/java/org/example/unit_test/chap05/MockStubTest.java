package org.example.unit_test.chap05;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MockStubTest {

    @Test
    void mock_stub_함께쓰기() {
        Store storeMock = Mockito.mock(Store.class);
        Customer sut = new Customer();

        // storeMock 첫 번째 목적: 준비된 응답 반환(stub)
        Mockito.when(storeMock.hasEnoughInventory("shampoo", 5))
                .thenReturn(false);

        assertThat(sut.purchase(storeMock, "shampoo", 5)).isFalse();
        // storeMock 두 번째 목적: 메서드 호출 검증(mock)
        Mockito.verify(storeMock, Mockito.never()).removeInventory("shampoo", 5);
    }

    private static class Store {

        private final Map<String, Integer> storage = new HashMap<>();

        public boolean hasEnoughInventory(String product, int quantity) {
            return storage.get(product) >= quantity;
        }

        public void removeInventory(String product, int quantity) {
            storage.computeIfPresent(product, (key, value) -> value - quantity);
        }

    }

    private static class Customer {

        public boolean purchase(Store store, String product, int quantity) {
            if (store.hasEnoughInventory(product, quantity)) {
                store.removeInventory(product, quantity);
                return true;
            }
            return false;
        }

    }

}

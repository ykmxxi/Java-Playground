package org.example.unit_test.chap05;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CustomerControllerTest {

    // 현재 클라이언트의 목표: 상품 구매
    @DisplayName("외부 시스템에 목을 사용해 취약한 테스트로 이어지지 않음")
    @Test
    void 올바른_목_사용() {
        EmailGateway emailGatewayMock = Mockito.mock(EmailGateway.class);
        CustomerController sut = new CustomerController(emailGatewayMock);

        boolean isSuccess = sut.purchase(1L, 1L, 5);

        assertThat(isSuccess).isTrue();
        Mockito.verify(emailGatewayMock, Mockito.times(1))
                .sendReceipt("eamil@eamil.com", new Product("Shampoo"), 5);
    }

    @DisplayName("취약한 테스트로 이어지는 목 사용: 시스템 내부(intra-system) 통신에 목 사용")
    @Test
    void 잘못된_목_사용() {
        Store storeMock = Mockito.mock(Store.class); // 시스템 내부 클래스
        Product product = new Product("Shampoo");
        Mockito.when(storeMock.hasEnoughInventory(product, 5))
                .thenReturn(true);
        Customer sut = new Customer(1L); // 시스템 내부 클래스

        boolean success = sut.purchase(storeMock, product, 5);

        assertThat(success).isTrue();
        Mockito.verify(storeMock, Mockito.times(1))
                .removeInventory(product, 5); // 목표인 상품 구매와 직접적인 연관이 없음, 목표에 가기 위한 중간단계
        // 검증을 하려면 removeInventory()의 호출이 아닌 구매 후 최종 수량의 상태: 이전 보다 5개 적은지
    }

}

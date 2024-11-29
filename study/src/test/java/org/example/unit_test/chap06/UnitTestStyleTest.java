package org.example.unit_test.chap06;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UnitTestStyleTest {

    @DisplayName("출력 기반(Output-based): SUT에 입력을 넣고 생성되는 출력을 검증")
    @Test
    void 출력_기반_테스트() {
        List<Product> products = List.of(new Product("Shampoo", 10_000L), new Product("BodyWash", 8_000L));
        PriceEngine sut = new PriceEngine();

        double discount = sut.calculateDiscount(products);

        assertThat(discount).isEqualTo(0.02d);
    }

    @DisplayName("상태 기반(State-based): 작업이 완료된 수 시스템(SUT, 협력자, 외부 의존성 등)의 상태를 확인")
    @Test
    void 상태_기반_테스트() {
        Product shampoo = new Product("Shampoo", 10_000L);
        Order sut = new Order();

        sut.addProduct(shampoo);

        List<Product> products = sut.getProducts(); // sut 상태
        assertThat(products.size()).isEqualTo(1);
        assertThat(products.getFirst()).isEqualTo(shampoo);
    }

    @DisplayName("통신 기반(Communication-based): 목을 사용해 SUT와 협력자 간의 통신을 검증")
    @Test
    void 통신_기반_테스트() {
        EmailGateway emailGatewayMock = Mockito.mock(EmailGateway.class);
        Controller sut = new Controller(emailGatewayMock);
        String email = "mail@mail.com";

        sut.greetUser(email);

        Mockito.verify(emailGatewayMock, Mockito.times(1))
                .sendGreetingsEmail(email);
    }

    static class Controller {

        private final EmailGateway emailGateway;

        public Controller(final EmailGateway emailGateway) {
            this.emailGateway = emailGateway;
        }

        public void greetUser(final String email) {
            emailGateway.sendGreetingsEmail(email);
        }

    }

    static class EmailGateway {

        public void sendGreetingsEmail(final String email) {}

    }

}

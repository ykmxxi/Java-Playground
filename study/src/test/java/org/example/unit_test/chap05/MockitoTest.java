package org.example.unit_test.chap05;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MockitoTest {

    @Test
    void mockito_test() {
        // 생성된 인스턴스인 emailGateway가 테스트 대역으로서의 mock
        EmailGateway mock = Mockito.mock(EmailGateway.class); // mock 역할: 모방하고 검사
        // 생성된 인스턴스인 emailRepository가 stub 역할, Mock 라이브러리를 사용한다고 무조건 Mock이 아님
        EmailRepository stub = Mockito.mock(EmailRepository.class); // stub 역할: 모방만 진행
        Controller sut = new Controller(mock, stub);

        Mockito.when(stub.findById(Mockito.anyLong()))
                .thenReturn("my-email");

        assertThat(sut.sendEmail()).isEqualTo("ok");
        Mockito.verify(mock, Mockito.times(1)).send("my-email");
        assertThat(sut.findEmail(1L)).isEqualTo("my-email");
    }

    @DisplayName("SUT 최종 결과를 검증하지 않고, 스텁과의 상호 작용을 검증하는 것은 리팩터링 내성을 낮추는 안티패턴")
    @Test
    void stub_안티패턴() {
        EmailGateway mock = Mockito.mock(EmailGateway.class);
        EmailRepository stub = Mockito.mock(EmailRepository.class);
        Controller sut = new Controller(mock, stub);

        Mockito.when(stub.findById(Mockito.anyLong()))
                .thenReturn("my-email");

        assertThat(sut.findEmail(1L)).isEqualTo("my-email");

        // 과잉 명세(Over specification): 최종 결과가 아닌 사항을 검증, 스텁과의 상호 작용을 검증
        Mockito.verify(stub, Mockito.times(1))
                .findById(Mockito.anyLong());
    }

    private static class Controller {

        private final EmailGateway emailGateway;
        private final EmailRepository emailRepository;

        public Controller(final EmailGateway emailGateway, final EmailRepository emailRepository) {
            this.emailGateway = emailGateway;
            this.emailRepository = emailRepository;

        }

        public String sendEmail() {
            emailGateway.send("my-email");
            return "ok";
        }

        public String findEmail(Long emailId) {
            return emailRepository.findById(emailId);
        }

    }

    private interface EmailGateway {

        void send(String mail);

    }

    private interface EmailRepository {

        String findById(Long id);

    }

}

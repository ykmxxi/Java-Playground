package org.example.unit_test.chap04;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageRendererTest {

    // MessageRenderer의 식별할 수 있는 동작을 실제로 확인하는 테스트인가?
    @DisplayName("SUT가 생성한 결과가 아닌 SUT의 구현 세부 사항과 결합한 테스트 -> 리팩터링 내성 낮음")
    @Test
    void messageRenderer_uses_correct_sub_renderers() {
        var sut = new MessageRenderer();

        List<IRenderer> subRenderers = sut.subRenderers();

        assertThat(subRenderers.get(0)).isInstanceOf(HeaderRenderer.class);
        assertThat(subRenderers.get(1)).isInstanceOf(BodyRenderer.class);
        assertThat(subRenderers.get(2)).isInstanceOf(FooterRenderer.class);
    }

    @DisplayName("MessageRenderer의 최종 결과는 렌더링 된 메시지 -> 리팩터링 내성 높음")
    @Test
    void rendering_message() {
        var sut = new MessageRenderer();
        var message = new Message("h", "b", "f");

        // 세부 구현 사항이 변경돼도 렌더링 된 메시지가 같다면 실패하지 않음 -> 리팩터링 내성이 높음
        assertThat(sut.render(message))
                .isEqualTo("Header: h\nBody: b\nFooter: f\n");
    }

}

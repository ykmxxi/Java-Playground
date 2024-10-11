package org.example.study;

import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestCaseScenarioTest {

     /*
     테스트 케이스와 본질적으로 동일하고 먼저 정의되어 있는
     **요구사항을 바르게 이해해야**

     요구사항: B 장비와 연결이 끊어지면 사용자 화면의 B 장비 박스가 회색이 된다
     - 요구사항을 잘못 이해하면: 연결이 끊어지면 200 OK를 반환, 200 OK 오는지 확인

     요구사항을 구체화 해서 이해하면 아주 예외적인 상황을 제외한 테스트 케이스 작성 가능
     - 요구사항 다시 이해: 연결이 끊어지면 장비 박스가 회색이 되는지 확인한다
     */

    private EquipmentBox box;

    @BeforeEach
    void setUp() {
        box = new EquipmentBox();
        System.out.println("연결 요청: " + box.connected);
    }

    @Test
    @DisplayName("잘못된 시나리오: 테스트 절차 or 예상결과 중 하나가 비존재 -> 잘못된 테케 작성")
    void badScenario() {
        // 연결 끊기 요청 -> 요청을 끊어 200 OK 반환
        String result = box.disconnect();

        // 의미 있는 검증? 아니다, 의미 없는 검증
        // 사용자가 보는 화면의 박스 색깔이 회색인지 확인해야 한다
        assertThat(result).isEqualTo("200 OK");
    }

    @Test
    @DisplayName("좋은 시나리오: 테스트 절차 + 예상결과")
    void goodScenario() {
        // 연결 끊기 요청 -> 요청을 끊고 장비 박스가 회색이 된다
        String result = box.disconnect();

        assertThat(box.isGray()).isTrue();
    }

    private static class EquipmentBox {

        private boolean connected;
        private Color color;

        public String connect() {
            connected = true;
            color = GREEN;
            return "200 OK"; // 연결 요청도 200 OK
        }

        public String disconnect() {
            connected = false;
            color = GRAY;
            return "200 OK"; // 연결 끊기도 200 OK
        }

        public boolean isGray() {
            return GRAY.equals(color);
        }

    }

}

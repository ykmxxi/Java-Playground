package chap03.item11;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EqualsHashCodeTest {

    @Test
    @DisplayName("equals() 재정의, hashCode() 재정의 X: 논리적 동치성을 재정의, hashCode()는 기본 구현 사용")
    void hashCode_재정의_없음() {
        Map<PhoneNumber1, String> map = new HashMap<>();

        PhoneNumber1 phoneNumber1 = new PhoneNumber1(101, 202, 303);
        map.put(phoneNumber1, "Kim");

        PhoneNumber1 phoneNumber2 = new PhoneNumber1(101, 202, 303);
        assertThat(phoneNumber1.equals(phoneNumber2)).isTrue(); // equals()는 동일한 객체라 판단
        assertThat(map.containsKey(phoneNumber2)).isFalse();
    }

    @Test
    @DisplayName("equals() & hashCode() 모두 재정의")
    void hashCode_재정의_존재() {
        Map<PhoneNumber2, String> map = new HashMap<>();
        PhoneNumber2 phoneNumber1 = new PhoneNumber2(101, 202, 303);
        PhoneNumber2 phoneNumber2 = new PhoneNumber2(101, 202, 303);
        map.put(phoneNumber1, "Kim");

        assertThat(phoneNumber1).isEqualTo(phoneNumber2);
        assertThat(phoneNumber1.hashCode()).isEqualTo(phoneNumber2.hashCode());
        assertThat(map.containsKey(phoneNumber2)).isTrue();
        assertThat(map.get(phoneNumber2)).isEqualTo("Kim");
    }

}

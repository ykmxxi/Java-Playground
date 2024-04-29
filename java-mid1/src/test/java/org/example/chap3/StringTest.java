package org.example.chap3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void 문자열_클래스_기능() {
        String str = "Hello World, Java";

        assertThat(str.indexOf("World")).isEqualTo(6);
        assertThat(str.substring(0, 6).trim()).isEqualTo("Hello");
        assertThat(str.substring(6)).isEqualTo("World, Java");
    }

    @Test
    @DisplayName("문자열 비교는 무조건 equals() 메서드 사용")
    void 문자열_비교_equals() {
        String str1 = new String("hello"); // x001
        String str2 = "hello"; // x002
        String str3 = "hello"; // x003

        // == 비교
        assertThat(isSame1(str1, str2)).isFalse();
        assertThat(isSame1(str2, str3)).isTrue();

        // 문자열 리터럴로 생성하면 문자열 풀에 존재하는 같은 인스턴스를 참조
        assertThat(System.identityHashCode(str2)).isEqualTo(System.identityHashCode(str3));

        // equals() 비교
        assertThat(isSame2(str1, str2)).isTrue();
        assertThat(isSame2(str2, str3)).isTrue();
    }

    private boolean isSame1(final String x, final String y) {
        // 파라미터로 넘어온 문자열이 문자열 리터럴로 생성되었는지, new String()으로 인스턴스 생성 방식이 사용되었는지 모름
        return x == y;
    }

    private boolean isSame2(final String x, final String y) {
        return x.equals(y);
    }

}

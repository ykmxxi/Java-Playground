package chap03.item10;

import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EqualsRuleTest {

    @Test
    @DisplayName("getClass()와 instanceof 비교")
    void getClassInstanceof() {
        Point p = new Point(1, 2); // super
        ColorPoint cp = new ColorPoint(1, 2, RED); // sub

        assertThat(p.getClass() == cp.getClass()).isFalse(); // always false
        // 자식은 부모를 담을 수 없다
        assertThat(p instanceof ColorPoint).isFalse(); // always false
        // 부모는 자식을 담을 수 있다
        assertThat(cp instanceof Point).isTrue(); // always true
    }

    @Test
    @DisplayName("대칭성(symmetry): 서로에 대한 동치 여부에 똑같이 답해야 한다")
    void 대칭성_위배() {
        IgnoreCaseString1 ics1 = new IgnoreCaseString1("JAVA"); // 대칭성 위배
        IgnoreCaseString2 ics2 = new IgnoreCaseString2("JAVA"); // 대칭성 준수
        String str = "Java";

        assertThat(ics1.equals(str)).isTrue();
        assertThat(str.equals(ics1)).isFalse();

        assertThat(ics2.equals(str)).isFalse();
        assertThat(str.equals(ics2)).isFalse();
    }

    @Test
    @DisplayName("추이성(transitivity): x == y && y == z -> x == z")
    void 추이성_위배() {
        ColorPoint cp1 = new ColorPoint(1, 2, BLUE);
        Point p = new Point(1, 2);
        ColorPoint cp2 = new ColorPoint(1, 2, RED);

        assertThat(cp1.equals(p)).isTrue(); // true
        assertThat(p.equals(cp2)).isTrue(); // true
        assertThat(cp1.equals(cp2)).isFalse(); // false
    }

    @Test
    @DisplayName("상속 대신 합성을 사용해 equals() 규약 지키기")
    void 추이성_만족_합성_사용() {
        CompositionColorPoint cp1 = new CompositionColorPoint(new Point(1, 2), BLUE);
        Point p = new Point(1, 2);
        CompositionColorPoint cp2 = new CompositionColorPoint(new Point(1, 2), RED);

        assertThat(cp1.equals(p)).isFalse(); // false
        assertThat(p.equals(cp2)).isFalse(); // false
        assertThat(cp1.equals(cp2)).isFalse(); // false

        assertThat(cp1.asPoint().equals(p)).isTrue(); // true
        assertThat(p.equals(cp2.asPoint())).isTrue(); // true
        assertThat(cp1.asPoint().equals(cp2.asPoint())).isTrue(); // true
    }


    static class IgnoreCaseString1 {

        private final String str;

        public IgnoreCaseString1(final String str) {
            this.str = Objects.requireNonNull(str);
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj instanceof IgnoreCaseString1 o) {
                return str.equalsIgnoreCase(o.str);
            }
            if (obj instanceof String o) {
                return str.equalsIgnoreCase(o);
            }
            return false;
        }

    }

    static class IgnoreCaseString2 {

        private final String str;

        public IgnoreCaseString2(final String str) {
            this.str = Objects.requireNonNull(str);
        }

        @Override
        public boolean equals(final Object obj) {
            return obj instanceof IgnoreCaseString2 && ((IgnoreCaseString2) obj).str.equalsIgnoreCase(this.str);
        }

    }

}

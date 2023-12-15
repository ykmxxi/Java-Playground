package deepcopy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CopyTest {

    private static final Logger log = LoggerFactory.getLogger(CopyTest.class);

    @Test
    @DisplayName("얕은 복사: 객체 참조값을 복사해 전달")
    void 얕은_복사() {
        List<Integer> original = new ArrayList<>();
        original.add(1);
        original.add(2);
        original.add(3);

        List<Integer> shallowCopy = original;
        original.add(4);

        assertThat(original.size()).isEqualTo(4);
        log.info("original ref : [{}]", System.identityHashCode(original));
        assertThat(shallowCopy.size()).isEqualTo(4);
        log.info("shallow shallowCopy ref : [{}]", System.identityHashCode(shallowCopy));
    }

    @Test
    @DisplayName("방어적 복사: 원본과의 관계를 끊어내고 전달, 하지만 Member는 같은 객체를 참조 중")
    void 방어적_복사() {
        List<Member> original = new ArrayList<>();
        original.add(new Member("userA", 10));
        original.add(new Member("userB", 20));

        List<Member> defensiveCopy = new ArrayList<>(original);
        original.add(new Member("userC", 30));

        for (Member member : original) {
            log.info("original member ref : [{}]", member);
        }
        assertThat(original.size()).isEqualTo(3);

        for (Member member : defensiveCopy) {
            log.info("defensiveCopy member ref : [{}]", member);
        }
        assertThat(defensiveCopy.size()).isEqualTo(2);

        for (int i = 0; i < 2; i++) {
            assertThat(original.get(i)).isEqualTo(defensiveCopy.get(i));
        }
    }

    @Test
    @DisplayName("Collections unmodifiableList: 읽기 전용 리스트 반환, 원본이 변경되면 영향을 받음")
    void 읽기_전용_불변_리스트() {
        Member member = new Member("a", 10);

        List<Integer> unmodifiableList = member.getNumbers();
        assertThat(unmodifiableList.size()).isEqualTo(3);
        assertThat(unmodifiableList).isEqualTo(List.of(1, 2, 3));

        // 원본 변경
        member.add(4);

        assertThat(unmodifiableList.size()).isEqualTo(4);
        assertThat(unmodifiableList).isEqualTo(List.of(1, 2, 3, 4));

        log.info("original ref : [{}]", member.getRef());
        log.info("unmodifiableList ref : [{}]", System.identityHashCode(unmodifiableList));
    }

    @Test
    @DisplayName("복사 생성자 + unmodifiableList: 완벽한 깊은 복사, 요소들의 관계도 모두 끊어냄")
    void 깊은_복사() {
        List<Car> original = new ArrayList<>();
        original.add(new Car("a", 1));
        original.add(new Car("b", 1));

        List<Car> deepCopy = original.stream()
                .map(Car::new)
                .toList();

        for (int i = 0; i < original.size(); i++) {
            log.info("original car's ref : [{}]", original.get(i));
            log.info("deep copy car's ref : [{}]", deepCopy.get(i));
        }

        original.add(new Car("c", 1));
        assertThat(original.size()).isEqualTo(3);
        assertThat(deepCopy.size()).isEqualTo(2);

        // 읽기 전용 리스트: 추가, 삭제, 변경 시 UnsupportedOperationException 예외 발생
        assertThatThrownBy(() -> deepCopy.add(new Car("d", 1)))
                .isInstanceOf(UnsupportedOperationException.class);
    }

}

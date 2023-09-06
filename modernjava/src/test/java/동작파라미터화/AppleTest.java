package 동작파라미터화;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;
import static 동작파라미터화.Color.GREEN;
import static 동작파라미터화.Color.RED;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import 동작파라미터화.predicate.ApplePredicate;
import 동작파라미터화.predicate.GreenColorPredicate;
import 동작파라미터화.predicate.HeavyWeightPredicate;

class AppleTest {

	private static final List<Apple> inventory = List.of(
		new Apple(100, RED),
		new Apple(300, RED),
		new Apple(700, RED),
		new Apple(50, GREEN),
		new Apple(240, GREEN),
		new Apple(400, GREEN)
	);

	private ApplePredicate predicate;

	@Test
	@DisplayName("무게 Predicate 테스트: 무게 150 초과는 무거운 사과")
	void weightPredicateTest() {
		// given
		List<Apple> heavyApples = new ArrayList<>();
		predicate = new HeavyWeightPredicate();

		// when
		applyPredicate(heavyApples);

		// then
		assertThat(heavyApples.size()).isEqualTo(4);
	}

	@Test
	@DisplayName("색깔 Predicate: 초록색 사과만 필터링")
	void greenColorPredicateTest() {
		// given
		List<Apple> greenApples = new ArrayList<>();
		predicate = new GreenColorPredicate();

		// when
		applyPredicate(greenApples);

		// then
		assertThat(greenApples.size()).isEqualTo(3);
	}

	@Test
	@DisplayName("색깔 Predicate: 람다를 이용해 빨간 사과만 필터링")
	void redColorPredicateTest() {
		// given
		List<Apple> redApples = new ArrayList<>();

		// when
		predicate = (Apple a) -> RED.equals(a.getColor());
		applyPredicate(redApples);

		// then
		assertThat(extractProperty("Color", Color.class).from(redApples)).containsOnly(RED);
	}

	private void applyPredicate(List<Apple> apples) {
		for (Apple apple : inventory) {
			if (predicate.test(apple)) {
				apples.add(apple);
			}
		}
	}

}

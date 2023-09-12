package 스트림;

import static org.assertj.core.api.Assertions.assertThat;
import static 스트림.Dish.Type.FISH;
import static 스트림.Dish.Type.MEAT;
import static 스트림.Dish.Type.OTHER;

import java.util.List;

import org.junit.jupiter.api.Test;

class FindAndMatchTest {

	private static final List<Dish> menu = List.of(
		new Dish("pork", false, 800, MEAT),
		new Dish("beef", false, 700, MEAT),
		new Dish("chicken", false, 400, MEAT),
		new Dish("french fries", true, 530, OTHER),
		new Dish("rice", true, 350, OTHER),
		new Dish("season fruit", true, 120, OTHER),
		new Dish("pizza", true, 550, OTHER),
		new Dish("prawns", false, 400, FISH),
		new Dish("salmon", false, 450, FISH)
	);

	@Test
	void isAllDishesCaloriesUnderThousandTest() {
		assertThat(FindAndMatch.isAllDishesCaloriesUnderThousand(menu)).isTrue();
	}

	@Test
	void isVegetarianMenuTest() {
		assertThat(FindAndMatch.isVegetarianMenu(menu)).isTrue();
	}

	@Test
	void getVegetarianDishTest() {
		Dish vegetarianDish = FindAndMatch.getVegetarianDish(menu);

		assertThat(vegetarianDish.isVegetarian()).isTrue();
	}

}

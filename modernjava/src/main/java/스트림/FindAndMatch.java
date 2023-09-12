package 스트림;

import java.util.List;

public class FindAndMatch {

	public static boolean isAllDishesCaloriesUnderThousand(List<Dish> menu) {
		return menu.stream()
				   .allMatch(dish -> dish.getCalories() < 1000);
	}

	public static boolean isVegetarianMenu(List<Dish> menu) {
		return menu.stream()
				   .anyMatch(Dish::isVegetarian);
	}

	public static Dish getVegetarianDish(List<Dish> menu) {
		return menu.stream()
				   .filter(Dish::isVegetarian)
				   .findAny()
				   .orElse(null);
	}

}

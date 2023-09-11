package 스트림;

import static 스트림.Dish.Type.MEAT;
import static 스트림.Dish.Type.OTHER;

import java.util.List;

public class StreamMain {

	public static void main(String[] args) {
		List<Dish> menu = List.of(
			new Dish("rice", true, 300, OTHER),
			new Dish("chicken", false, 1400, MEAT),
			new Dish("pizza", false, 1800, OTHER),
			new Dish("salad", true, 80, OTHER)
		);

		List<Dish> lowCaloricDishes = Dish.lowCaloricDishes(menu);
		for (Dish lowCaloricDish : lowCaloricDishes) {
			System.out.println("lowCaloricDish = " + lowCaloricDish);
		}
	}

}

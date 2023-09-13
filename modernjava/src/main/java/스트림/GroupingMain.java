package 스트림;

import static 스트림.Dish.Type.FISH;
import static 스트림.Dish.Type.MEAT;
import static 스트림.Dish.Type.OTHER;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingMain {

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

	public static void main(String[] args) {
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
													  .collect(Collectors.groupingBy(Dish::getType));
		for (Map.Entry<Dish.Type, List<Dish>> entry : dishesByType.entrySet()) {
			System.out.println("key = " + entry.getKey() + ", values = " + entry.getValue());
		}
		System.out.println(dishesByType);
	}

}

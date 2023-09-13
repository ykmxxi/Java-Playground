package 스트림;

import static 스트림.Dish.Type.FISH;
import static 스트림.Dish.Type.MEAT;
import static 스트림.Dish.Type.OTHER;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsMain {

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
		// 스트림값에서 최대값과 최소값 검색
		Comparator<Dish> comparator = Comparator.comparingInt(Dish::getCalories);

		Optional<Dish> mostCalorieDish = menu.stream()
											 .collect(Collectors.maxBy(comparator));
		Optional<Dish> leastCalorieDish = menu.stream()
											  .collect(Collectors.minBy(comparator));

		System.out.println("mostCalorieDish = " + mostCalorieDish);
		System.out.println("leastCalorieDish = " + leastCalorieDish);

		// 요약 연산
		int totalCalories = menu.stream()
								.collect(Collectors.summingInt(Dish::getCalories));
		double averageCalories = menu.stream()
									 .collect(Collectors.averagingDouble(Dish::getCalories));

		System.out.println("totalCalories = " + totalCalories);
		System.out.println("averageCalories = " + averageCalories);

		// 문자열 연결
		String menuNames = menu.stream()
							   .map(Dish::getName)
							   .collect(Collectors.joining(", "));
		System.out.println("menuNames = " + menuNames);

		// 범용 리듀싱 요약 연산: Collectors.reducing
		totalCalories = menu.stream()
							.collect(Collectors.reducing(
								0, Dish::getCalories, Integer::sum
							));
		System.out.println("totalCalories = " + totalCalories);
		mostCalorieDish = menu.stream()
							  .collect(Collectors.reducing(
								  (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2
							  ));
		System.out.println("mostCalorieDish = " + mostCalorieDish);
	}

}

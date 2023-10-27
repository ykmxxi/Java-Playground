package 스트림;

import static 스트림.Dish.Type.FISH;
import static 스트림.Dish.Type.MEAT;
import static 스트림.Dish.Type.OTHER;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        List<Dish> menu = List.of(
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

        List<Dish> lowCaloricDishes = Dish.lowCaloricDishes(menu);
        for (Dish lowCaloricDish : lowCaloricDishes) {
            System.out.println("lowCaloricDish = " + lowCaloricDish);
        }

        List<String> threeHighCaloricDishNames = menu.stream()
                                                     .filter(dish -> dish.getCalories() > 300)
                                                     .map(Dish::getName)
                                                     .limit(3)
                                                     .collect(Collectors.toList());
        System.out.println("threeHighCaloricDishNames = " + threeHighCaloricDishNames);

        List<String> vegetarianDishNames = menu.stream()
                                               .filter(Dish::isVegetarian)
                                               .map(Dish::getName)
                                               .collect(Collectors.toList());
        System.out.println("vegetarianDishNames = " + vegetarianDishNames);

        List<String> lowCaloriesMenuTypeNames = menu.stream()
                                                    .filter(dish -> dish.getCalories() < 450)
                                                    .map(Dish::getType)
                                                    .distinct() // 고유 요소 필터링
                                                    .map(String::valueOf)
                                                    .collect(Collectors.toList());
        System.out.println("lowCaloriesMenuTypeNames = " + lowCaloriesMenuTypeNames);

        List<Dish> sortedByCalories = menu.stream()
                                          .sorted(Comparator.comparingInt(Dish::getCalories))
                                          .collect(Collectors.toList());

        List<Dish> sliceMenu = sortedByCalories.stream()
                                               .takeWhile(dish -> dish.getCalories() < 450)
                                               .collect(Collectors.toList());
        System.out.println("sliceMenu = " + sliceMenu);

        List<Dish> highCaloriesMenu = sortedByCalories.stream()
                                                      .dropWhile(dish -> dish.getCalories() < 450)
                                                      .collect(Collectors.toList());
        System.out.println("highCaloriesMenu = " + highCaloriesMenu);

        List<Dish> topThreeHighCaloriesMenu = menu.stream()
                                                  .sorted(Comparator.comparingInt(Dish::getCalories).reversed())
                                                  .limit(3)
                                                  .collect(Collectors.toList());
        System.out.println("topThreeHighCaloriesMenu = " + topThreeHighCaloriesMenu);
    }

}

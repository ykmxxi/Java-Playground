package 스트림;

import static 스트림.Dish.Type.FISH;
import static 스트림.Dish.Type.MEAT;
import static 스트림.Dish.Type.OTHER;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionMain {

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
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                                                       .collect(Collectors.partitioningBy(Dish::isVegetarian));

        List<Dish> forVegetarian = partitionedMenu.get(true);
        System.out.println("forVegetarian = " + forVegetarian);

        Map<Boolean, List<Integer>> numbers = IntStream.rangeClosed(2, 100)
                                                       .boxed()
                                                       .collect(Collectors.partitioningBy(PartitionMain::isPrime));
        List<Integer> primeNumbers = numbers.get(true);
        System.out.println("primeNumbers = " + primeNumbers);

    }

    private static boolean isPrime(int cand) {
        return IntStream.rangeClosed(2, (int)Math.sqrt(cand))
                        .noneMatch(i -> cand % i == 0);
    }

}

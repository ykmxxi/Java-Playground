package 스트림;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public static List<Dish> lowCaloricDishes(List<Dish> menu) {
        return menu.stream()
                   .filter(dish -> dish.getCalories() < 400)
                   .sorted(Comparator.comparing(Dish::getCalories))
                   .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

}

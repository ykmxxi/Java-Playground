package 메서드참조;

import static 동작파라미터화.Color.GREEN;
import static 동작파라미터화.Color.RED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import 동작파라미터화.Apple;
import 동작파라미터화.Color;

public class MethodReferenceMain {

	public static void main(String[] args) {
		List<Integer> weights = Arrays.asList(100, 150, 200, 300, 160);
		List<Color> colors = Arrays.asList(GREEN, RED, GREEN, RED, GREEN);

		List<Apple> apples = map(weights, colors, Apple::new);
		for (Apple apple : apples) {
			System.out.println("apple = " + apple);
		}
	}

	public static List<Apple> map(List<Integer> weights, List<Color> colors, BiFunction<Integer, Color, Apple> f) {
		List<Apple> result = new ArrayList<>();

		for (int i = 0; i < weights.size(); i++) {
			result.add(f.apply(weights.get(i), colors.get(i)));
		}
		return result;
	}

}

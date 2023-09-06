package 동작파라미터화.predicate;

import 동작파라미터화.Apple;
import 동작파라미터화.Color;

public class GreenColorPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return Color.GREEN.equals(apple.getColor());
	}

}

package 동작파라미터화.predicate;

import 동작파라미터화.Apple;

public class HeavyWeightPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}

}

package 열거형;

import java.util.function.BiFunction;

public enum Operator {
	PLUS("더하기", (a, b) -> (a + b)),
	MINUS("빼기", (a, b) -> (a - b)),
	MULTIPLY("곱하기", (a, b) -> (a * b)),
	DIVIDE("나누기", (a, b) -> (a / b));

	private final String description;
	private final BiFunction<Double, Double, Double> biFunction;

	Operator(String description, BiFunction<Double, Double, Double> biFunction) {
		this.description = description;
		this.biFunction = biFunction;
	}

	public double calculate(double n1, double n2) {
		return this.biFunction.apply(n1, n2);
	}

}

class Main {

	public static void main(String[] args) {
		double plusResult = Operator.PLUS.calculate(1, 2);
		System.out.println("plusResult = " + plusResult);
	}

}

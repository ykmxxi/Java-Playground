package 람다표현식;

public class FunctionalInterfaceMain {

	private static void process(Runnable r) {
		r.run();
	}

	public static void main(String[] args) {
		// 람다 사용
		Runnable r1 = () -> System.out.println("Hello World");
		process(r1);

		// 람다 표현식 직접 전달
		process(() -> System.out.println("Hello World"));
	}

}

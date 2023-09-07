package 람다표현식;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceMain {

	private static final String FILE_PATH = "/Users/ykm/Desktop/projects/Java-Playground/modernjava/src/main/java/람다표현식/data.txt";

	private static void process(Runnable r) {
		r.run();
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			return p.process(br);
		}
	}

	/**
	 * Predicate: test() 추상 메서드를 정의하고 있는 함수형 인터페이스
	 * test(): 제네릭 형식의 T 객체를 인수로 받아 boolean 반환
	 */
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();

		for (T t : list) {
			if (p.test(t)) {
				results.add(t);
			}
		}
		return results;
	}

	/**
	 * Function: apply() 추상 메서드를 정의하고 있는 함수형 인터페이스
	 * apply(): 제네릭 형식 T를 받아 제네릭 형식의 R을 반환
	 */
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();

		for (T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}

	public static void main(String[] args) {
		// 람다 사용
		Runnable r1 = () -> System.out.println("Hello World");
		process(r1);

		// 람다 표현식 직접 전달
		process(() -> System.out.println("Hello World"));
	}

}

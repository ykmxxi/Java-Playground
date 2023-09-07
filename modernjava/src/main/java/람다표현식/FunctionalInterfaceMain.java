package 람다표현식;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

	public static void main(String[] args) {
		// 람다 사용
		Runnable r1 = () -> System.out.println("Hello World");
		process(r1);

		// 람다 표현식 직접 전달
		process(() -> System.out.println("Hello World"));
	}

}

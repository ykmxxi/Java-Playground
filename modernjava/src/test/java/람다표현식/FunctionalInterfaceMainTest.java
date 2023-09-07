package 람다표현식;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FunctionalInterfaceMainTest {

	@Test
	@DisplayName("람다 활용: 실행 어라운드 패턴")
	void executeAroundPatternTest() throws IOException {
		// when
		String oneLine = FunctionalInterfaceMain.processFile((BufferedReader br) -> br.readLine());
		String twoLine = FunctionalInterfaceMain.processFile((BufferedReader br) -> br.readLine() + br.readLine());

		// then
		assertThat(oneLine).isEqualTo("첫 번째 줄");
		assertThat(twoLine).isEqualTo("첫 번째 줄두 번째 줄");
	}

	@Test
	@DisplayName("Predicate: 비어있거나 공백인 문자를 필터링")
	void predicateTest() {
		// given
		Predicate<String> rejectEmptyOrWhitespaces = (String s) -> !s.isBlank();
		List<String> words = List.of("   ", "Hi", "Hello", "", "World ");
		List<String> result = new ArrayList<>();

		// when
		result = FunctionalInterfaceMain.filter(words, rejectEmptyOrWhitespaces);

		// then
		assertThat(result.size()).isEqualTo(3);
		assertThat(result).containsExactly("Hi", "Hello", "World ");
	}

}

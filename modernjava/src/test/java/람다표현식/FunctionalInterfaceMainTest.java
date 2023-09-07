package 람다표현식;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;

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

}

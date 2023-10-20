package jdk11;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringMethodInJdk11Test {

	/**
	 * isBlank(): empty() + 공백의 문자열이 들어오면 true를 반환
	 */
	@Test
	@DisplayName("신규 문자열 Method 기능: isBlank()")
	void isBlank_test() {
		String empty = "";
		String whitespaces = "    ";

		assertThat(empty.isBlank()).isTrue();
		assertThat(whitespaces.isBlank()).isTrue();
	}

	/**
	 * lines(): 개행문자(\n, \r, \r\n)를 기준으로 여러 줄의 문자열을 Stream<String>으로 반환
	 */
	@Test
	@DisplayName("신규 문자열 Method 기능: lines()")
	void lines_test() {
		// given
		String multiLine = "Hello\nWorld\rJDK11\r\nCOOL";

		// when
		List<String> result = multiLine.lines()
									   .map(String::trim)
									   .toList();

		// then
		assertThat(result).containsExactly("Hello", "World", "JDK11", "COOL");
		System.out.println("lines() result to list = " + result);
	}

	/**
	 * strip(): 문자열 앞 뒤의 공백들을 제거
	 * - 스페이스('\u0020') 이하 공백만 제거하는 trim() 보다 더 많은 공백 문자들을 제거할 수 있음
	 * stripLeading(): 문자열 앞의 공백만 제거
	 * stripTrailing(): 문자열 뒤의 공백만 제거
	 */
	@Test
	@DisplayName("신규 문자열 Method 기능: strip()")
	void strip_test() {
		// given
		String input = "  Hello\u2003"; // \u2003: Em Space 공백

		// when
		String strip = input.strip();
		String stripLeading = input.stripLeading();
		String stripTrailing = input.stripTrailing();

		// then
		assertThat(strip).isEqualTo("Hello");
		assertThat(stripLeading).isEqualTo("Hello\u2003");
		assertThat(stripTrailing).isEqualTo("  Hello");
	}

	/**
	 * repeat(): 인수로 받은 count 수 만큼 문자열을 반복해 반환
	 */
	@Test
	@DisplayName("신규 문자열 Method 기능: repeat()")
	void repeat_test() {
		// given
		String abc = "abc";

		// when
		String result = abc.repeat(2);

		// then
		assertThat(result).isEqualTo("abcabc");
	}

}

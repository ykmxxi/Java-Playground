package org.example.chap3;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringMethodTest {


    @Test
    @DisplayName("문자열 정보 조회 메서드")
    void 문자열_정보_조회() {
        String emptyStr = "";
        String whiteSpaces = "    ";
        String str = "Hello, Java";

        // length(): 문자열의 길이 조회
        assertThat(emptyStr.length()).isEqualTo(0);
        assertThat(whiteSpaces.length()).isGreaterThan(0);
        assertThat(str.length()).isGreaterThan(0);

        // isEmpty(): 문자열이 비었는지 확인
        assertThat(emptyStr.isEmpty()).isTrue();
        assertThat(whiteSpaces.isEmpty()).isFalse();
        assertThat(str.isEmpty()).isFalse();

        // isBlank(): 문자열이 비었는지 && 공백으로 이루어졌는지 확인, Java 11 이후
        assertThat(emptyStr.isBlank()).isTrue();
        assertThat(whiteSpaces.isBlank()).isTrue();
        assertThat(str.isBlank()).isFalse();

        // charAt(): 특정 인덱스의 문자 반환
        assertThat(whiteSpaces.charAt(0)).isEqualTo(' ');
        assertThat(str.charAt(0)).isEqualTo('H');
    }

    @Test
    @DisplayName("문자열 비교 메서드")
    void 문자열_비교() {
        String str1 = "Hello, Java!"; // 대문자 일부 있음
        String str2 = "hello, java!"; // 대문자 없음 모두 소문자
        String str3 = "Hello, World!";

        assertThat(str1.equals(str2)).isFalse(); // 대소문자도 비교
        assertThat(str1.equalsIgnoreCase(str2)).isTrue(); // 대소문자 비교 X

        assertThat(str1.compareTo(str2)).isLessThan(0); // 대문자가 사전순 먼저옴
        assertThat(str1.compareToIgnoreCase(str2)).isEqualTo(0);

        assertThat(str1.startsWith("Hello")).isTrue();
        assertThat(str1.endsWith("Java!")).isTrue();
    }

    @Test
    @DisplayName("문자열 검색 메서드")
    void 문자열_검색() {
        String str = "Hello, Java! Welcome to Java world";

        assertThat(str.contains("Java")).isTrue();

        assertThat(str.indexOf("Java")).isEqualTo(7); // 처음으로 나온 인덱스

        assertThat(str.indexOf("Java", 10)).isEqualTo(24);

        assertThat(str.lastIndexOf("Java")).isEqualTo(24);
    }

    @Test
    @DisplayName("문자열 조작 및 변환 메서드")
    void 문자열_조작_변환() {
        String str = "Hello, Java! Welcome to Java";
        String strWithSpaces = "         Java Programming     ";

        assertThat(str.substring(7)).isEqualTo("Java! Welcome to Java");
        assertThat(str.substring(7, 12)).isEqualTo("Java!");

        assertThat(str.concat("!")).endsWith("!");

        assertThat(str.replaceAll("Java", "World")).doesNotContain("Java");
        assertThat(str.replaceFirst("Java", "World")).contains("Java");

        // 공백 제거
        // trim: Whitespace만 제거, strip: 유니코드 공백도 제거
        assertThat(strWithSpaces.trim()).isEqualTo("Java Programming");
        assertThat(strWithSpaces.strip()).isEqualTo("Java Programming");
    }

    @Test
    @DisplayName("문자열 분할 및 조합")
    void 문자열_분할_조합() {
        String str = "Apple,Banana,Orange";

        // 문자열 분할
        String[] split = str.split(",");
        assertThat(split).containsExactly("Apple", "Banana", "Orange");

        // 문자열 조합
        String join = String.join("-", split);
        assertThat(join).isEqualTo("Apple-Banana-Orange");
    }

    @Test
    @DisplayName("기타 유틸리티")
    void 기타_유틸리티() {
        assertThat(valueOf(true)).isEqualTo("true");
        assertThat(valueOf(100)).isEqualTo("100");

        // 문자 + x -> 문자
        assertThat("" + 100).isEqualTo("100");

        assertThat("hello".toCharArray()).containsExactly('h', 'e', 'l', 'l', 'o');

        assertThat(String.format("%.2f", 10.1234)).isEqualTo("10.12");
        assertThat(String.format("%.2f", 10.1256)).isEqualTo("10.13"); // 반올림
    }

}

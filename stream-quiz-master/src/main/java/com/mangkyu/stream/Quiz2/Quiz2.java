package com.mangkyu.stream.Quiz2;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Quiz2 {

	private static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

	// 2.1 List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라.
	// ex) ("T", 1), ("a", 2) ...
	public Map<String, Integer> quiz1() {
		return WORDS.stream()
					.map(word -> word.substring(0, 1)) // 접두사를 추출
					.collect(toMap(pre -> pre, pre -> 1, Integer::sum)); // key: 접두사, value: 초기 값(1), 동일한 키가 있을 경우 합산
	}

	// 2.2 List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
	// ex) ["Hello", "a", "Island", "b"] -> “H I”
	public String quiz2() {
		return WORDS.stream()
					.filter(word -> word.length() > 1) // 길이가 2 이상인 경우만 필터링
					.map(word -> word.substring(0, 1)) // 접두사 추출
					.map(String::toUpperCase) // 대문자로 변환
					.collect(joining(" ")); // 공백(스페이스)로 구분해 하나의 문자열로
	}

}

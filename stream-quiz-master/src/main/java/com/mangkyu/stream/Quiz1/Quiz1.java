package com.mangkyu.stream.Quiz1;

import static java.util.stream.Collectors.toMap;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;

public class Quiz1 {

	// 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
	public Map<String, Integer> quiz1() throws IOException {
		List<String[]> csvLines = readCsvLines();

		return csvLines.stream()
					   .map(line -> line[1].trim()) // 취미는 2번 째 값, 공백을 제거
					   .flatMap(line -> Arrays.stream(line.split(":"))) // 취미는 :로 구분되어 있음, 한 수준으로 평면화(중복 제거)
					   // key: 취미, value: 선호 인원, mergeFunction: 기존 키 값이 존재하면 새로운 값으로 대체
					   .collect(toMap(hobby -> hobby, hobby -> 1, (oldVal, newVal) -> newVal += oldVal));
	}

	// 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
	public Map<String, Integer> quiz2() throws IOException {
		List<String[]> csvLines = readCsvLines();

		// key: 취미, value: 정씨 성을 가진 사람의 수
		return csvLines.stream()
					   .filter(line -> line[0].startsWith("정")) // 정씨 성을 가진 사람만
					   .map(line -> line[1].trim()) // 취미는 2번 째 값, 공백을 제거
					   .flatMap(line -> Arrays.stream(line.split(":"))) // 취미는 :로 구분되어 있음, 한 수준으로 평면화(중복 제거)
					   // key: 취미, value: 선호 인원, mergeFunction: 기존 키 값이 존재하면 새로운 값으로 대체
					   .collect(toMap(hobby -> hobby, hobby -> 1, (oldVal, newVal) -> newVal += oldVal));
	}

	// 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
	public int quiz3() throws IOException {
		List<String[]> csvLines = readCsvLines();
		return 0;
	}

	private List<String[]> readCsvLines() throws IOException {
		CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
		csvReader.readNext();
		return csvReader.readAll();
	}

}

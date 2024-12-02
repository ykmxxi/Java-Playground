package org.example.unit_test.chap06.v0;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

/** 리팩터링 전 초기 시스템
 * 회귀 방지: 좋음
 * 리팩터링 내성: 좋음
 * 빠른 피드백: 나쁨(파일 시스템과 결합해 테스트가 느림)
 * 유지 보수성: 나쁨
 */
public class AuditManagerV1 {

    private int maxEntriesPerFile;
    private String directoryName;

    public AuditManagerV1(final int maxEntriesPerFile, final String directoryName) {
        this.maxEntriesPerFile = maxEntriesPerFile;
        this.directoryName = directoryName;
    }

    public void addRecord(final String visitorName, final LocalDateTime timeOfVisit) throws IOException {
        String newRecord = visitorName + " : " + timeOfVisit + System.lineSeparator();

        // 전체 파일 목록을 검색
        Path directory = Path.of(directoryName);
        try (Stream<Path> paths = Files.list(directory)) {
            List<Path> files = paths.sorted() // 인덱스 별 정렬
                    .toList();
            // 파일이 없으면 생성 후 저장
            if (files.isEmpty()) {
                String fileName = directoryName + "audit_1.txt";
                Path file = Files.createFile(Path.of(fileName));
                Files.writeString(file, newRecord, UTF_8, APPEND);
                return;
            }

            // 최신 파일을 가져와 저장
            Path lastFile = files.getLast();
            List<String> lines = Files.readAllLines(lastFile);
            if (lines.size() < maxEntriesPerFile) {
                Files.writeString(lastFile, newRecord, UTF_8, APPEND);
                return;
            }
            // 파일 항목 수가 최대에 도달하면 새로 파일 생성 후 저장
            String[] split = lastFile.getFileName().toString()
                    .split("_");
            int fileIndex = Integer.parseInt(split[1].substring(0, 1)) + 1;
            String fileName = directoryName + "audit_" + fileIndex + ".txt";
            Path file = Files.createFile(Path.of(fileName));
            Files.writeString(file, newRecord, UTF_8, APPEND);
        }
    }

}

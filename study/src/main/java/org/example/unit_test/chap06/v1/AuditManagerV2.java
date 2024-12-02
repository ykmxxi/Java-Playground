package org.example.unit_test.chap06.v1;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 리팩터링 전 초기 시스템
 * 회귀 방지: 좋음
 * 리팩터링 내성: 좋음
 * 빠른 피드백: 나쁨(파일 시스템과 결합해 테스트가 느림)
 * 유지 보수성: 나쁨
 */
public class AuditManagerV2 {

    private int maxEntriesPerFile;
    private String directoryName;
    private IFileSystem fileSystem;

    public AuditManagerV2(final int maxEntriesPerFile, final String directoryName, final IFileSystem fileSystem) {
        this.maxEntriesPerFile = maxEntriesPerFile;
        this.directoryName = directoryName;
        this.fileSystem = fileSystem;
    }

    public void addRecord(final String visitorName, final LocalDateTime timeOfVisit) throws IOException {
        String newRecord = visitorName + " : " + timeOfVisit + System.lineSeparator();

        // 전체 파일 목록을 검색
        List<String> files = fileSystem.getFiles(directoryName);
        // 파일이 없으면 생성 후 저장
        if (files.isEmpty()) {
            String fileName = "audit_1.txt";
            Path newFile = fileSystem.createNewFile(directoryName, fileName);
            fileSystem.write(newFile, newRecord);
            return;
        }

        // ...
    }

}

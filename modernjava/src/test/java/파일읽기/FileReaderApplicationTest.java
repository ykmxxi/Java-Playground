package 파일읽기;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileReaderApplicationTest {

    @DisplayName("백엔드 크루 파일 읽기")
    @Test
    void 백엔드_크루_파일_읽기() {
        // given
        String path = "src/main/resources/backend-crew.md";

        // when
        List<String> names = FileReaderApplication.readFile(path);

        // then
        assertThat(names).contains("백호", "태웅", "태산", "용팔", "구식", "달재");
    }

    @DisplayName("프론트엔드 크루 파일 읽기")
    @Test
    void 프론트엔드_크루_파일_읽기() {
        // given
        String path = "src/main/resources/frontend-crew.md";

        // when
        List<String> names = FileReaderApplication.readFile(path);

        // then
        //보노 시저 쉐리 신디 다비 덴버 이브 제시 라라 린다 리사 니콜 로드 윌터 제키
        assertThat(names).contains("보노", "신디", "리사", "로드", "윌터", "제키");
    }

    @DisplayName("파일이 존재하지 않는 경우 IllegalArgumentException 예외 발생")
    @Test
    void 파일이_존재하지_않는_경우() {
        // given
        String path = "src/main/resources/fullstack-crew.md";

        // when & then
        assertThatThrownBy(() -> FileReaderApplication.readFile(path))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 파일이 존재하지 않습니다.");
    }

}

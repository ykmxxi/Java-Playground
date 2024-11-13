package charset;

import static java.nio.charset.StandardCharsets.US_ASCII;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.Charset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EncodingTest {

    @DisplayName("한글은 MS949, EUC_KR 지원, 둘 다 ASCII 코드와 호환 가능")
    @Test
    void 한글_인코딩() {
        Charset EUC_KR = Charset.forName("EUC-KR");
        Charset MS_949 = Charset.forName("MS949");

        assertThat(EUC_KR.contains(US_ASCII)).isTrue();
        assertThat(MS_949.contains(US_ASCII)).isTrue();
        assertThat(US_ASCII.contains(EUC_KR)).isFalse();
        assertThat(US_ASCII.contains(MS_949)).isFalse();
    }

}

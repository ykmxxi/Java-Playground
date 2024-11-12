import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void hello() {
        assertThat("Hello").isEqualTo("Hello");
    }

}

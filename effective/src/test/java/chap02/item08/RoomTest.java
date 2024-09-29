package chap02.item08;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoomTest {

    @Test
    @DisplayName("try-with-resources(finally)를 사용하면 애초에 안전망이 필요없다")
    void tryWithResources() {
        Room room = new Room(10);
        try {
        } finally {
            room.close();
        }
        assertThat(room.isCleaned()).isTrue();
    }

    @Test
    @DisplayName("자원 정리를 하지 않을 수 있다. close()를 호출해도 자원 정리가 보장되지 않는다")
    void cleaner() {
        Room room = new Room(10);
//        room.close();
        assertThat(room.isCleaned()).isFalse();

    }

}

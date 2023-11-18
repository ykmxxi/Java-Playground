package 상속;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CaffeineBeverageTest {

    @Test
    @DisplayName("커피(Coffee)는 카페인 음료다(CaffeineBeverage)")
    void 커피는_카페인_음료() {
        // given
        Coffee coffee = new Coffee();

        // when & then
        assertThat(coffee).isInstanceOf(CaffeineBeverage.class);
    }

    @Test
    @DisplayName("업캐스팅: 하위 클래스를 상위 클래스로 타입을 변환하는 것, 다운캐스팅: 상위 클래스를 하위 클래스의 타입으로 변환하는 것")
    void 업캐스팅_다운캐스팅() {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();
        CaffeineBeverage caffeineBeverage = new Coffee();

        assertThat(coffee).isInstanceOf(Coffee.class);
        assertThat(tea).isInstanceOf(Tea.class);
        assertDoesNotThrow(() -> {
            Coffee downCastingCoffee = (Coffee) caffeineBeverage;
        });
    }

}

package 일급컬렉션;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstClassCollectionTest {

	@Test
	@DisplayName("final 키워드: 불변을 보장하지 않고 재할당을 막는다")
	void final_키워드() {
		// given
		final List<String> list = new ArrayList<>();

		// when
		list.add("1");
		list.add("2");

		// then
		assertThat(list).containsExactly("1", "2");
	}

}

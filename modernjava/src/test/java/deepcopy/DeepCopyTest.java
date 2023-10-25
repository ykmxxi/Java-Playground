package deepcopy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DeepCopyTest {

	@Test
	void deepCopyTest() {
		// given
		List<Member> original = new ArrayList<>();
		original.add(new Member("김", 10));
		original.add(new Member("이", 20));

		// when
		List<Member> unmodifiableList = Collections.unmodifiableList(original);

		List<Member> deepCopy = original.stream()
										.toList();

		original.add(new Member("박", 3));
		original.set(0, new Member("새로운 김", 30));

		// then
		assertThat(original).isEqualTo(unmodifiableList);
		assertThat(original).isNotEqualTo(deepCopy);

		assertThat(original.get(0)).isEqualTo(unmodifiableList.get(0));
		assertThat(original.get(0)).isNotEqualTo(deepCopy.get(0));

		for (Member member : original) {
			System.out.println("original member = " + member);
		}
		for (Member member : unmodifiableList) {
			System.out.println("unmodifiable member = " + member);
		}
		for (Member member : deepCopy) {
			System.out.println("deep_copy member = " + member);
		}

	}

	static class Member {

		private final String name;
		private final int age;

		public Member(final String name, final int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

	}

}

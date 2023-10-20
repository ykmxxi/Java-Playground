package jdk17;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MemberTest {

	@Test
	void record_test() {
		// given
		Member member1 = new Member("이름", 10);
		Member member2 = new Member("이름", 10);
		Member member3 = new Member("이름", 20);

		// when
		String memberName = member1.name();
		int memberAge = member1.age();

		// then
		// getter 테스트
		assertThat(memberName).isEqualTo("이름");
		assertThat(memberAge).isEqualTo(10);

		// equals() & hashcode() 테스트
		assertThat(member1).isEqualTo(member2);
		assertThat(member1).isNotEqualTo(member3);

		System.out.println(member1);
	}

}

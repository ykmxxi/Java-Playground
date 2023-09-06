package com.mangkyu.stream.Quiz6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Quiz6Test {

	private final Answer6 answer = new Answer6();
	private final Quiz6 quiz = new Quiz6();

	@Test
	void quiz1() {
		assertThat(quiz.quiz1()).isEqualTo(answer.quiz1());
	}

	@Test
	void quiz2() {
		assertThat(quiz.quiz2()).isEqualTo(answer.quiz2());
	}

}

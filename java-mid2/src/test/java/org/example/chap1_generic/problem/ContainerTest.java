package org.example.chap1_generic.problem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ContainerTest {

    @Test
    void test() {
        Container<String> stringContainer = new Container<>();

        assertThat(stringContainer.isEmpty()).isTrue();

        stringContainer.setItem("data1");
        assertThat(stringContainer.getItem()).isEqualTo("data1");
        assertThat(stringContainer.isEmpty()).isFalse();

        Container<Integer> integerContainer = new Container<>();
        integerContainer.setItem(10);

        assertThat(integerContainer.getItem()).isEqualTo(10);
        assertThat(integerContainer.isEmpty()).isFalse();
    }

}

package org.example.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;

import org.junit.jupiter.api.Test;

class ReflectionTest {

    @Test
    void Class_객체_획득() throws Exception {
        Class<Member> memberClassA = Member.class;

        Member member = new Member("reflection", 10);
        Class<? extends Member> memberClassB = member.getClass();

        Class<?> memberClassC = Class.forName("org.example.reflection.Member");

        assertThat(memberClassA).isIn(Member.class);
        assertThat(memberClassB).isIn(Member.class);
        assertThat(memberClassC).isIn(Member.class);

        Constructor<Member> constructorA = memberClassA.getDeclaredConstructor(String.class, int.class);
        Constructor<? extends Member> constructorB = memberClassB.getDeclaredConstructor(String.class, int.class);
        Constructor<?> constructorC = memberClassC.getDeclaredConstructor(String.class, int.class);

        Member memberA = constructorA.newInstance("A", 10);
        Member memberB = constructorB.newInstance("B", 20);
        Member memberC = (Member) constructorC.newInstance("C", 30);

        assertThat(memberA.getName()).isEqualTo("A");
        assertThat(memberA.getAge()).isEqualTo(10);
        assertThat(memberB.getName()).isEqualTo("B");
        assertThat(memberB.getAge()).isEqualTo(20);
        assertThat(memberC.getName()).isEqualTo("C");
        assertThat(memberC.getAge()).isEqualTo(30);

        Constructor<Member> privateConstructor = memberClassA.getDeclaredConstructor(String.class);
        privateConstructor.setAccessible(true);
        Member privateMember = privateConstructor.newInstance("private");

        assertThat(privateMember.getName()).isEqualTo("private");
        assertThat(privateMember.getAge()).isEqualTo(1);
    }

}

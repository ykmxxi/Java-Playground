package org.example.reflection;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ReflectionTest {

    @Test
    void Class_객체_획득() throws Exception {
        Class<Member> memberClassA = Member.class;

        Member member = new Member(1L, "reflection", 10);
        Class<? extends Member> memberClassB = member.getClass();

        Class<?> memberClassC = Class.forName("org.example.reflection.Member");

        assertThat(memberClassA).isIn(Member.class);
        assertThat(memberClassB).isIn(Member.class);
        assertThat(memberClassC).isIn(Member.class);

        Constructor<Member> constructorA = memberClassA.getDeclaredConstructor(long.class, String.class, int.class);
        Constructor<? extends Member> constructorB = memberClassB.getDeclaredConstructor(long.class, String.class, int.class);
        Constructor<?> constructorC = memberClassC.getDeclaredConstructor(long.class, String.class, int.class);

        Member memberA = constructorA.newInstance(1L, "A", 10);
        Member memberB = constructorB.newInstance(1L, "B", 20);
        Member memberC = (Member) constructorC.newInstance(1L, "C", 30);

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

    @Test
    void getXXXs_getDeclaredXXXs() {
        Class<Member> memberClass = Member.class;

        List<String> methodNames = Arrays.stream(memberClass.getMethods())
                .map(Method::getName)
                .toList();

        assertThat(methodNames).contains("publicMethod");
        assertThat(methodNames).doesNotContain("baseEntityPrivateMethod"); // 오직 public 요소만 가져옴
        System.out.println("getMethods name list");
        for (String methodName : methodNames) {
            System.out.println("methodName = " + methodName);
        }

        System.out.println();

        List<String> declaredMethodNames = Arrays.stream(memberClass.getDeclaredMethods())
                .map(Method::getName)
                .toList();

        assertThat(declaredMethodNames).contains("memberPrivateMethod");
        assertThat(declaredMethodNames).doesNotContain("publicMethod"); // 상위 클래스의 메소드는 가져오지 않음

        System.out.println("getDeclaredMethods name list");
        for (String declaredMethodName : declaredMethodNames) {
            System.out.println("declaredMethodName = " + declaredMethodName);
        }

    }

}

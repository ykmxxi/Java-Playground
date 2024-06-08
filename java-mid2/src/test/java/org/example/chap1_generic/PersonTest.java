package org.example.chap1_generic;

import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void test() {
        Person<String, Integer> person = new Person<>("kim", 20);

        System.out.println("person.name = " + person.getName());
        System.out.println("person.age = " + person.getAge());
    }

}

package org.example.reflection;

public class Member {

    private String name;
    private int age;

    public Member(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    private Member(final String name) {
        this.name = name;
        this.age = 1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

package io.member;

import java.io.Serializable;

public class Member implements Serializable {

    private final String id;
    private final String name;
    private final Integer age;

    public Member(final String id, final String name, final Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Integer age() {
        return age;
    }

}

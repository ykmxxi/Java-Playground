package org.example.reflection;

public class Member extends BaseEntity {

    private String name;
    private int age;

    public Member(final long id, final String name, final int age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    private Member(final String name) {
        super(1L);
        this.name = name;
        this.age = 1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void memberPrivateMethod() {
        System.out.println("private do something");
    }

}

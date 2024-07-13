package org.example.chap10.compare;

public class MyUser implements Comparable<MyUser> {

    private final String id;
    private final int age;

    public MyUser(final String id, final int age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(final MyUser o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }

}

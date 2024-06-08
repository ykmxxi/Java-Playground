package org.example.chap1_generic;

// 한번에 여러 타입 매개변수를 선언할 수 있다
public class Person<K, V> {

    private final K name;
    private final V age;

    public Person(final K name, final V age) {
        this.name = name;
        this.age = age;
    }

    public K getName() {
        return name;
    }

    public V getAge() {
        return age;
    }

}

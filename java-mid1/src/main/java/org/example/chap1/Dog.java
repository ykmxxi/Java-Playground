package org.example.chap1;

public class Dog {

    private String name;

    public Dog() {
        this.name = "default";
    }

    public Dog(final String name) {
        this.name = name;
    }

    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

}

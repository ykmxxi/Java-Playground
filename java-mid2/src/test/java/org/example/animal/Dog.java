package org.example.animal;

public class Dog extends Animal {

    public Dog(final String name, final int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

}

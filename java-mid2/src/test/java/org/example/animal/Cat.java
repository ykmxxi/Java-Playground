package org.example.animal;

public class Cat extends Animal {

    public Cat(final String name, final int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("냐옹");
    }

}

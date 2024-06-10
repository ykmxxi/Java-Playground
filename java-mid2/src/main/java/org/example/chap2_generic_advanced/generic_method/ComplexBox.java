package org.example.chap2_generic_advanced.generic_method;

import org.example.animal.Animal;

public class ComplexBox<T extends Animal> {

    private T animal;

    public void setAnimal(final T animal) {
        this.animal = animal;
    }

    // 제네릭 메서드가 우선권을 갖는다
    public <T> T printAndReturn(final T t) {
        System.out.println("animal.getClass().getName() = " + animal.getClass().getName());
        System.out.println("t.getClass().getName() = " + t.getClass().getName());
        return t;
    }

}

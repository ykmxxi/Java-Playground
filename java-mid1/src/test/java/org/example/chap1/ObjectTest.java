package org.example.chap1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class ObjectTest {

    @Test
    void object_method_test() {
        Parent parent = new Parent();
        Child child = new Child();
        Child copy = child;

        assertAll(
                parent::parentMethod,
                child::childMethod,
                child::parentMethod
        );

        assertThat(parent.toString()).isNotNull();
        assertThat(child.equals(copy)).isEqualTo(true);
        assertThat(child.toString()).isNotNull();

        assertThat(parent.getClass()).isInstanceOf(Object.class);
        assertThat(child.getClass()).isInstanceOf(Object.class);
    }

    @Test
    void object_다형성() {
        assertDoesNotThrow(() -> {
            Object obj1 = new Car();
            if (obj1 instanceof Car car) {
                car.move();
            }

            Object obj2 = new Dog();
            if (obj2 instanceof Dog dog) {
                dog.sound();
            }
        });
    }

}

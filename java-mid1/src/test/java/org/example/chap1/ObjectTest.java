package org.example.chap1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    void object_배열() {
        Dog dog = new Dog();
        Car car = new Car();
        Object obj = new Object();

        // Object 배열은 모든 객체를 담을 수 있다
        Object[] objects = {dog, car, obj};

        assertThat(objects.length).isEqualTo(3);
    }

    @Test
    @DisplayName("Car 객체는 toString 오버라이딩 X, Dog 객체는 toString 오버라이딩 O")
    void toString_오버라이딩() {
        Car car = new Car();
        Dog dog = new Dog("Jack");

        assertThat(toStringCall(car)).startsWith("org.example.chap1.Car");
        System.out.println("car = " + car);

        // 오버라이딩된 toString 메서드가 존재하면 해당 메서드를 사용
        assertThat(toStringCall(dog)).contains("Jack");
        System.out.println("dog = " + dog);

        String ref = dog.getClass().getCanonicalName() + "@" + Integer.toHexString(System.identityHashCode(dog));
        System.out.println("ref = " + ref);
        assertThat(ref).startsWith("org.example.chap1.Dog");
    }

    private String toStringCall(final Object obj) {
        return obj.toString();
    }

}

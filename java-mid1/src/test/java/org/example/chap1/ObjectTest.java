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

    @Test
    @DisplayName("Object 클래스가 제공하는 equals()는 == 연산으로 객체의 참조값이 동일한지 비교")
    void object_equals() {
        String id = "id-100";
        UserV1 user1 = new UserV1(id);
        UserV1 user2 = new UserV1(id);

        assertThat(user1.equals(user2)).isFalse();
        assertThat(user1.getId()).isEqualTo(user2.getId());
    }

    @Test
    @DisplayName("논리적 지위가 같은 객체를 동등하다 판단하기 위해 equals() 메서드 오버라이딩 필요")
    void equals_오버라이딩() {
        String id = "id-100";
        UserV2 user1 = new UserV2(id);
        UserV2 user2 = new UserV2(id);

        assertThat(user1.equals(user2)).isTrue(); // 동등한 관계(논리적 지위가 같다)
        assertThat(user1 == user2).isFalse(); // 하지만 참조값이 다름
    }

}

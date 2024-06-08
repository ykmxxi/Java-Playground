package org.example.chap1_generic;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.animal.Animal;
import org.example.animal.Cat;
import org.example.animal.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoxTest {

    @Test
    @DisplayName("다형성 활용 가능")
    void animal() {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);

        Box<Animal> box = new Box<>();
        box.setValue(animal);
        box.setValue(dog);
        box.setValue(cat);

        assertThat(box.getValue().getName()).isEqualTo("냐옹이");
        assertThat(box.getValue().getSize()).isEqualTo(50);
    }

}

package org.example.chap2_generic_advanced.wildcard;

import static org.example.chap2_generic_advanced.wildcard.WildCardEx.printAndReturnWildcard;

import org.example.animal.Animal;
import org.example.animal.Cat;
import org.example.animal.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WildCardExTest {

    @Test
    void 제네릭_메서드() {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        objBox.setValue("hello");
        dogBox.setValue(new Dog("멍멍이", 100));
        catBox.setValue(new Cat("냐옹이", 50));

        WildCardEx.printGenericV1(objBox);
        // WildCardEx.printGenericV2(objBox); // 상한 제한으로 컴파일 오류

        WildCardEx.printGenericV1(dogBox);
        WildCardEx.printGenericV2(dogBox);
        Animal returnDog = WildCardEx.printAndReturnGeneric(dogBox);

        WildCardEx.printGenericV1(catBox);
        WildCardEx.printGenericV2(catBox);
        Animal returnCat = WildCardEx.printAndReturnGeneric(catBox);
    }

    @Test
    void 와일드카드() {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        objBox.setValue("hello");
        dogBox.setValue(new Dog("멍멍이", 100));
        catBox.setValue(new Cat("냐옹이", 50));

        WildCardEx.printWildcardV1(objBox);
        // WildCardEx.printWildcardV2(objBox); // 상한 제한으로 컴파일 오류

        WildCardEx.printWildcardV1(dogBox);
        WildCardEx.printWildcardV2(dogBox);
        Animal returnDog = printAndReturnWildcard(dogBox);

        WildCardEx.printWildcardV1(catBox);
        WildCardEx.printWildcardV2(catBox);
        Animal returnCat = printAndReturnWildcard(catBox);
    }

    @Test
    @DisplayName("상한 제한: ? extends Xxx, Xxx와 그 하위 타입만 가능")
    void 상한_제한() {
        String name = "name";
        int size = 10;

        Box<Object> objBox = new Box<>();
        objBox.setValue(new Animal(name, size));
        Box<Animal> animalBox = new Box<>();
        animalBox.setValue(new Animal(name, size));
        Box<Dog> dogBox = new Box<>();
        dogBox.setValue(new Dog(name, size));
        Box<Cat> catBox = new Box<>();
        catBox.setValue(new Cat(name, size));

        // WildCardEx.printWildcardV2(objBox); // 컴파일 에러: 상한 제한으로 Object X
        WildCardEx.printWildcardV2(animalBox);
        WildCardEx.printWildcardV2(dogBox);
        WildCardEx.printWildcardV2(catBox);
    }

    @Test
    @DisplayName("와일드카드를 사용하면 전달한 타입 매개변수를 받지 못하는 경우가 발생")
    void 타입_매개변수_필요한_경우() {
        Box<Dog> dogBox = new Box<>();
        dogBox.setValue(new Dog("name", 10));

        Animal returnDog = printAndReturnWildcard(dogBox); // 타입이 Animal
    }

    @Test
    @DisplayName("하한 제한: ? super Xxx, Xxx와 그 상위 타입만 가능")
    void 하한_제한() {
        String name = "name";
        int size = 10;

        Box<Object> objBox = new Box<>();
        objBox.setValue(new Animal(name, size));
        Box<Animal> animalBox = new Box<>();
        animalBox.setValue(new Animal(name, size));
        Box<Dog> dogBox = new Box<>();
        dogBox.setValue(new Dog(name, size));
        Box<Cat> catBox = new Box<>();
        catBox.setValue(new Cat(name, size));

        WildCardEx.superMethod(objBox);
        WildCardEx.superMethod(animalBox);
        // WildCardEx.superMethod(dogBox); // 컴파일 에러: 하한 제한으로 Dog X
        // WildCardEx.superMethod(catBox); // 컴파일 에러: 하한 제한으로 Cat X
    }

}

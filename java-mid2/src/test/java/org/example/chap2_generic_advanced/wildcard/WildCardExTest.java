package org.example.chap2_generic_advanced.wildcard;

import org.example.animal.Animal;
import org.example.animal.Cat;
import org.example.animal.Dog;
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
        Animal returnDog = WildCardEx.printAndReturnWildcard(dogBox);

        WildCardEx.printWildcardV1(catBox);
        WildCardEx.printWildcardV2(catBox);
        Animal returnCat = WildCardEx.printAndReturnWildcard(catBox);
    }

}

package org.example.chap2_generic_advanced.타입매개변수제한;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.example.animal.Cat;
import org.example.animal.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnimalHospitalTest {

    @Test
    @DisplayName("타입 안전성 O, 코드 재사용이 많음")
    void 각_타입별_클래스_생성() {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        dogHospital.setAnimal(new Dog("멍멍이", 100));
        catHospital.setAnimal(new Cat("냐옹이", 50));

        // dogHospital.setAnimal(new Cat("냐옹이", 50)); // 컴파일 오류
    }

    @Test
    @DisplayName("코드 재사용 없음, 타입 안전성 X")
    void 부모_타입_다형성() {
        AnimalHospitalV1 dogHospital = new AnimalHospitalV1();
        AnimalHospitalV1 catHospital = new AnimalHospitalV1();

        dogHospital.setAnimal(new Dog("멍멍이", 100));
        catHospital.setAnimal(new Cat("냐옹이", 50));

        // dogHospital에 Cat이 들어갈 수 있음
        dogHospital.setAnimal(new Cat("냐옹이", 50));

        // 다운 캐스팅이 필요 -> ClassCastException 발생 가능성 존재
        assertThatThrownBy(() -> {
            Dog bigger = (Dog) dogHospital.bigger(new Dog("멍멍이2", 40));
        }).isInstanceOf(ClassCastException.class);
    }

    @Test
    @DisplayName("제네릭에서 타입 매개변수를 사용하면 어떤 타입이든 들어올 수 있음, Object의 기능만 사용 가능")
    void 제네릭_타입_도입_실패() {
        AnimalHospitalV2<Dog> dogHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Cat> catHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<String> stringHospital = new AnimalHospitalV2<>(); // 어떤 타입이든 들어올 수 있음
        AnimalHospitalV2<Integer> integerHospital = new AnimalHospitalV2<>(); // 어떤 타입이든 들어올 수 있음
    }

    @Test
    @DisplayName("타입 매개변수 제한: Animal과 그 자식 타입으로만 제한")
    void 타입_매개변수_제한() {
        AnimalHospitalV3<Dog> dogHospital = new AnimalHospitalV3<>();
        AnimalHospitalV3<Cat> catHospital = new AnimalHospitalV3<>();

        dogHospital.setAnimal(new Dog("멍멍이", 100));
        catHospital.setAnimal(new Cat("냐옹이", 50));

        // 타입 제한 가능
        // dogHospital.setAnimal(new Cat("냐옹이", 50)); // 컴파일 오류 발생

        // 다운 캐스팅 오류 걱정 X
        Dog bigger = (Dog) dogHospital.bigger(new Dog("멍멍이2", 300));
        assertThat(bigger.getName()).isEqualTo("멍멍이2");
        assertThat(bigger.getSize()).isEqualTo(300);
    }

}

package org.example.chap2_generic_advanced.타입매개변수제한;

import org.example.animal.Animal;

public class AnimalHospitalV2<T> {

    private T animal;

    public void setAnimal(final T animal) {
        this.animal = animal;
    }

    public void checkup() {
        // Object의 기능만 사용 가능
        animal.toString();
        animal.equals(null);

        // 컴파일 오류: 타입 매개변수에 무엇이 들어올지 컴파일러는 알 수 없음
//        System.out.println("동물 이름 = " + animal.getName());
//        System.out.println("동물 크기 = " + animal.getSize());
//        animal.sound();
    }

    public Animal bigger(final Animal target) {
        // return animal.getSize() > target.getSize() ? animal : target;
        return null;
    }

}

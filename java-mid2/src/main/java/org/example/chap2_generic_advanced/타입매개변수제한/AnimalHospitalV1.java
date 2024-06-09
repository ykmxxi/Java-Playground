package org.example.chap2_generic_advanced.타입매개변수제한;

import org.example.animal.Animal;

public class AnimalHospitalV1 {

    private Animal animal;

    public void setAnimal(final Animal animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름 = " + animal.getName());
        System.out.println("동물 크기 = " + animal.getSize());
        animal.sound();
    }

    public Animal bigger(final Animal target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }

}

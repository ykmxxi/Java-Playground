package org.example.chap2_generic_advanced.wildcard;

import org.example.animal.Animal;

public class WildCardEx {

    public static <T> void printGenericV1(Box<T> box) {
        System.out.println("T = " + box.get());
    }

    public static void printWildcardV1(Box<?> box) {
        System.out.println("? = " + box.get());
    }

    // 상한 존재
    public static <T extends Animal> void printGenericV2(Box<T> box) {
        T animal = box.get();
        System.out.println("이름 = " + animal.getName() + ", 사이즈 = " + animal.getSize());
    }

    public static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName() + ", 사이즈 = " + animal.getSize());
    }

    public static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
        T animal = box.get();
        System.out.println("이름 = " + animal.getName() + ", 사이즈 = " + animal.getSize());
        return animal;
    }

    public static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName() + ", 사이즈 = " + animal.getSize());
        return animal;
    }

}

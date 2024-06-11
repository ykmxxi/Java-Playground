package org.example.chap2_generic_advanced.problem;

import org.example.chap2_generic_advanced.problem.unit.BioUnit;

public class UnitPrinter {

    // 제네릭 메서드
    public static <T extends BioUnit> void printV1(final Shuttle<T> shuttle) {
        T unit = shuttle.out();
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }

    // 와일드카드
    public static void printV2(final Shuttle<? extends BioUnit> shuttle) {
        BioUnit unit = shuttle.out();
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }

}

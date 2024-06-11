package org.example.chap2_generic_advanced.problem;

import org.example.chap2_generic_advanced.problem.unit.BioUnit;

public class Shuttle<T extends BioUnit> {

    private T unit;

    public void in(final T unit) {
        this.unit = unit;
    }

    public T out() {
        return unit;
    }

    public void showInfo() {
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }

}

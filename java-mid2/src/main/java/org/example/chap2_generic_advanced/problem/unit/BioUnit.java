package org.example.chap2_generic_advanced.problem.unit;

public class BioUnit {

    private String name;
    private int hp;

    public BioUnit(final String name, final int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "BioUnit{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }

}

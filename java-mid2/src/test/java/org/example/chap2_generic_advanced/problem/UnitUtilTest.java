package org.example.chap2_generic_advanced.problem;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.chap2_generic_advanced.problem.unit.Marine;
import org.example.chap2_generic_advanced.problem.unit.Zealot;
import org.junit.jupiter.api.Test;

class UnitUtilTest {

    @Test
    void problem1() {
        Marine marine1 = new Marine("마린1", 40);
        Marine marine2 = new Marine("마린2", 50);

        Marine resultMarine = UnitUtil.maxHp(marine1, marine2);
        assertThat(resultMarine.getName()).isEqualTo("마린2");
    }

    @Test
    void problem2() {
        Zealot zealot1 = new Zealot("질럿1", 100);
        Zealot zealot2 = new Zealot("질럿2", 150);

        Zealot resultZealot = UnitUtil.maxHp(zealot1, zealot2);
        assertThat(resultZealot.getName()).isEqualTo("질럿2");
    }

}

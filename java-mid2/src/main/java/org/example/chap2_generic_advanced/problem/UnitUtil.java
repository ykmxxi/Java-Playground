package org.example.chap2_generic_advanced.problem;

import org.example.chap2_generic_advanced.problem.unit.BioUnit;

public class UnitUtil {

    /**
     * 두 유닛 중 체력이 높은 유닛을 반환, 체력이 같은 경우 둘 중 아무나 반환
     */
    public static <T extends BioUnit> T maxHp(final T unit, final T anotherUnit) {
        if (unit.getHp() >= anotherUnit.getHp()) {
            return unit;
        }
        return anotherUnit;
    }

}

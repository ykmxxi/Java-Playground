package chap03.item14;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class CompareToTest {

    @Test
    void compareTo_equals_비교() {
        // 동치성 equals() 비교
        Set<BigDecimal> hashSet = new HashSet<>();
        // 동치성 compareTo() 비교
        Set<BigDecimal> treeSet = new TreeSet<>();

        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");
        hashSet.add(bd1);
        hashSet.add(bd2);
        treeSet.add(bd1);
        treeSet.add(bd2);

        assertThat(hashSet).hasSize(2);
        assertThat(treeSet).hasSize(1);
    }

}

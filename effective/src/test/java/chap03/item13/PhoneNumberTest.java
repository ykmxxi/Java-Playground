package chap03.item13;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PhoneNumberTest {

    @Test
    void clone_일반_규약() {
        PhoneNumber phoneNumber = new PhoneNumber(1, 2, 3);
        PhoneNumber clone = phoneNumber.clone();
        Set<PhoneNumber> set = new HashSet<>();
        set.add(phoneNumber);

        assertThat(phoneNumber == clone).isFalse();
        assertThat(phoneNumber.getClass() == clone.getClass()).isTrue();
        assertThat(phoneNumber.equals(clone)).isTrue();
        assertThat(set.contains(clone)).isTrue();
    }

}

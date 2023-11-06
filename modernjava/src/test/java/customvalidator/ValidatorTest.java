package customvalidator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 멤버_외_클래스_검증기_사용_불가() {
        Assertions.assertThatIllegalStateException()
                .isThrownBy(() -> {
                    Validator memberValidator = new MemberValidator();
                    memberValidator.supports(User.class);
                })
                .withMessageContaining("검증기를");
    }

}

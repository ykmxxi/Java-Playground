package customvalidator;

public class MemberValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        if (!Member.class.equals(clazz)) {
            throw new IllegalStateException("해당 클래스에서는 이 검증기를 사용할 수 없습니다.");
        }
        return true;
    }

    @Override
    public void validate(final Object target) {
        Member member = (Member) target;

        if (member.getName().isBlank()) {
            throw new IllegalArgumentException();
        }
    }

}

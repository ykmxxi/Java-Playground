package customvalidator;

public interface Validator {

    boolean supports(final Class<?> clazz);

    void validate(final Object target);
}

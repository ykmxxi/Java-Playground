package org.example.chap2;

public class ImmutableAddress {

    private final String value;

    public ImmutableAddress(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ImmutableAddress{" +
                "value='" + value + '\'' +
                '}';
    }

}

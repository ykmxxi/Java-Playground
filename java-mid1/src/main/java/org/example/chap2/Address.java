package org.example.chap2;

public class Address {

    private String value;

    Address(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Person{" +
                "value='" + value + '\'' +
                '}';
    }

}

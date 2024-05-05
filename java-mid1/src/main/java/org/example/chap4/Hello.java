package org.example.chap4;

public class Hello {

    private final String name;

    public Hello() {
        this.name = "default";
    }

    public Hello(final String name) {
        this.name = name;
    }

    public String hello() {
        return name + " hello world!";
    }

}

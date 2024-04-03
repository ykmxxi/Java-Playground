package org.example.reflection;

public class BaseEntity {

    private Long id;

    private BaseEntity() {
        this.id = 1L;
    }

    public BaseEntity(final Long id) {
        this.id = id;
    }

    private void baseEntityPrivateMethod() {
        System.out.println("private do something");
    }

    public void publicMethod() {
        System.out.println("public do something");
    }

}

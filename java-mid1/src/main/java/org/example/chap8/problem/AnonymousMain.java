package org.example.chap8.problem;

public class AnonymousMain {

    public void hello() {
        Hello hello = () -> System.out.println("Hello.hello");
    }

}

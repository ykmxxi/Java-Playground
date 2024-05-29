package org.example.chap8.anonymous;

import org.example.chap8.Printer;

public class AnonymousOuter {

    private final int outInstanceVar = 3;

    public void process(final int paramVar) {
        final int localVar = 1;

        Printer printer = new Printer() {
            final int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        };

        printer.print();

        // class org.example.chap8.anonymous.AnonymousOuter$1
        System.out.println("printer.class = " + printer.getClass());
    }

}

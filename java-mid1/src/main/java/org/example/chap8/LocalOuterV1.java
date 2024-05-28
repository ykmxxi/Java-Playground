package org.example.chap8;

public class LocalOuterV1 {

    private int outInstanceVar = 3;

    public void process(final int paramVar) {
        int localVar = 1;

        // 내부 클래스를 포함한 중첩 클래스들도 일반 클래스처럼 인터페이스를 구현하거나, 부모 클래스 상속 가능
        class LocalPrinter implements Printer {

            private int value = 0;

            @Override
            public void print() {
                // 자신의 인스턴스 멤버
                System.out.println("value = " + value);

                // 지역 변수
                System.out.println("localVar = " + localVar);

                // 매개변수
                System.out.println("paramVar = " + paramVar);

                // 바깥 클래스의 인스턴스 멤버
                System.out.println("outInstanceVar = " + outInstanceVar);
            }

        }

        LocalPrinter localPrinter = new LocalPrinter();
        localPrinter.print();
    }

}

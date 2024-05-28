package org.example.chap8;

public class LocalOuterV2 {

    private int outInstanceVar = 3;

    public Printer process(final int paramVar) {
        // 지역 변수는 스택 프레임이 종료되는 순간 함께 제거
        final int localVar = 1;

        class LocalPrinter implements Printer {

            private int value = 0;

            @Override
            public void print() {
                // 자신의 인스턴스 멤버
                System.out.println("value = " + value);

                // 지역 변수
                System.out.println("localVar = " + localVar);

                // 매개변수(지역 변수)
                System.out.println("paramVar = " + paramVar);

                // 바깥 클래스의 인스턴스 멤버, 인스턴스 멤버는 지역 변수보다 생명 주기가 길다
                System.out.println("outInstanceVar = " + outInstanceVar);
            }

        }

        Printer printer = new LocalPrinter();
        // printer.print();
        return printer;
    }

}

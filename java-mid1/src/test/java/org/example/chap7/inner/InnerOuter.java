package org.example.chap7.inner;

public class InnerOuter {

    private static final int OUT_CLASS_VAR = 3;
    private int outInstanceVar = 2;

    class Inner {

        private int innerInstanceVar = 1;

        public void print() {
            // 자기 자신에 접근
            System.out.println(innerInstanceVar);

            // 외부 클래스의 인스턴스 멤버에 접근 가능, private도 접근 가능
            System.out.println(outInstanceVar);

            // 외부 클래스의 클래스 멤버에 접근 가능, private도 접근 가능
            System.out.println(OUT_CLASS_VAR);
        }

    }

}

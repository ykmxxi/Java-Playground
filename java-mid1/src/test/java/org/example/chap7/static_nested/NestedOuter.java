package org.example.chap7.static_nested;

public class NestedOuter {

    private static final int OUT_CLASS_VAR = 3;
    private int outInstanceVar = 2;

    static class Nested {

        private int nestedInstanceVar = 1;

        public void print() {
            // 자신의 멤버에 접근 가능
            System.out.println(nestedInstanceVar);

            // 바깥 클래스의 인스턴스 멤버에 접근 불가능
            // System.out.println(outInstanceVar);

            // 바깥 클래스의 정적 멤버에 접근 가능, private 접근 제어자여도 가능
            System.out.println(OUT_CLASS_VAR);
        }

    }

}

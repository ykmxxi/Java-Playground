package chap8;

public class FinalLocalMain {

    public static void main(String[] args) {
        final int data1 = 10; // final 지역 변수: 최초 한번만 할당 가능
        // data1 = 20; // Compile Error

        method(10);
    }

    private static void method(final int param) {
        // param = 20; // Compile Error

    }

}

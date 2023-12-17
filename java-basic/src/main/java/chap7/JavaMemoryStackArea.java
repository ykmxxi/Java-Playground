package chap7;

public class JavaMemoryStackArea {

    public static void main(String[] args) {
        System.out.println("main start");

        method1(10); // method1 호출 후 종료되면 여기 라인으로 돌아옴

        System.out.println("main end");
    }

    static void method1(final int m1) {
        System.out.println("method1 start");

        int cal = m1 * 2;
        System.out.println("cal = " + cal);
        method2(cal); // method2 호출 후 종료되면 여기 라인으로 돌아옴
        System.out.println("method1 end");
    }

    static void method2(final int m2) {
        System.out.println("method2 start");
        System.out.println("m2 = " + m2);
        System.out.println("method2 end");
    }

}

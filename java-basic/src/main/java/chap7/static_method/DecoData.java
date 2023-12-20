package chap7.static_method;

public class DecoData {

    private static int staticValue;

    private int instanceValue;

    public static void staticCall() {
        // instanceValue++;  // 인스턴스 변수 접근 compile error
        // instanceMethod(); // 인스턴스 메서드 접근 compile error

        staticValue++; // 정적 변수 접근
        staticMethod(); // 정적 메서드 접근
    }

    public void instanceCall() {
        instanceValue++;  // 인스턴스 변수 접근
        instanceMethod(); // 인스턴스 메서드 접근

        staticValue++; // 정적 변수 접근
        staticMethod(); // 정적 메서드 접근
    }

    private static void staticMethod() {
        System.out.println("staticValue = " + staticValue);
    }

    private void instanceMethod() {
        System.out.println("instanceValue = " + instanceValue);
    }

}

package chap7;

public class StackAndHeapArea {

    public static void main(String[] args) {
        System.out.println("main start");

        method1();

        System.out.println("main end");
    }

    static void method1() {
        System.out.println("method1 start");
        Data data1 = new Data(10);
        System.out.println("data1 ref = " + data1);
        method2(data1);
        System.out.println("method1 end");
    }

    static void method2(Data data2) {
        System.out.println("method2 start");
        System.out.println("data2 ref = " + data2); // data1과 같은 인스턴스를 참조
        System.out.println("method2 end");
    }

}

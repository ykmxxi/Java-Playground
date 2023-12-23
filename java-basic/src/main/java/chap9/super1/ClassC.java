package chap9.super1;

public class ClassC extends ClassB {

    public ClassC(int a) {
        super(a, 0);
        System.out.println("ClassC 생성자");
    }

    public ClassC(int a, int b) {
        super(a, b);
        System.out.println("ClassC 생성자");
    }

}

package chap11.diamond;

public class C implements A, B {

    @Override
    public String methodA() {
        return "a";
    }

    @Override
    public String methodB() {
        return "b";
    }

    @Override
    public String common() {
        return "c";
    }

}

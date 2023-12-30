package chap11.ex;

public class SubClass extends SuperClass {

    public String value = "child";

    @Override
    public String get() {
        return "sub";
    }

}

package chap9.parent;

public class Parent {

    public String value = "parent";
    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void hello() {
        System.out.println("Parent.hello");
    }

    public void publicMethod() {
        System.out.println("Parent.publicMethod");
    }

    protected void protectedMethod() {
        System.out.println("Parent.protectedMethod");
    }

    void defaultMethod() {
        System.out.println("Parent.defaultMethod");
    }

    private void privateMethod() {
        System.out.println("Parent.privateMethod");
    }

    public void printParent() {
        System.out.println("== Parent 메서드 안 ===");
        System.out.println("publicValue = " + publicValue);
        System.out.println("protectedValue = " + protectedValue);
        System.out.println("defaultValue = " + defaultValue);
        System.out.println("privateValue = " + privateValue);

        defaultMethod();
        privateMethod();
    }

}

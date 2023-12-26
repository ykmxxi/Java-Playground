package chap10.override;

public class OverrideMain {

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println("child.value = " + child.value);
        child.method();
        System.out.println();

        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        System.out.println("parent.value = " + parent.value);
        parent.method();
        System.out.println();

        Parent poly = new Child();
        System.out.println("Parent -> Child");
        System.out.println("poly.value = " + poly.value);
        poly.method(); // 오버라이딩 메서드가 우선권을 갖는다
    }

}

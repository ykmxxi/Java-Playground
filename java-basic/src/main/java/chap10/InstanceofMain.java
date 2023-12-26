package chap10;

public class InstanceofMain {

    public static void main(String[] args) {
        Parent parent1 = new Parent();
        System.out.println("parent1 결과");
        call(parent1);

        Parent parent2 = new Child();
        System.out.println("parent2 결과");
        call(parent2);

        // JDK 16부터는 instanceof를 사용하면서 동시에 변수를 선언할 수 있다
        System.out.println("parent1 결과");
        callAfterJDK16(parent1);
        System.out.println("parent2 결과");
        callAfterJDK16(parent2);

    }

    private static void call(final Parent parent) {
        parent.parentMethod();

        if (parent instanceof Child) {
            System.out.println("Child 인스턴스가 맞음");
            Child child = (Child) parent;
            child.childMethod();
        } else {
            System.out.println("Child 인스턴스가 아님");
        }
    }

    private static void callAfterJDK16(final Parent parent) {
        parent.parentMethod();

        if (parent instanceof Child child) {
            System.out.println("Child 인스턴스가 맞음");
            child.childMethod();
        } else {
            System.out.println("Child 인스턴스가 아님");
        }
    }

}

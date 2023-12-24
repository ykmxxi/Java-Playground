package chap10;

public class PolyMain {

    public static void main(String[] args) {
        // 부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        parent.parentMethod();

        // 자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        // 부모 변수가 자식 인스턴스 참조, 부모는 자식을 담을 수 있음
        Parent poly1 = new Child();
        Parent poly2 = new Grandson();
        poly1.parentMethod();
        poly2.parentMethod();

        // poly1.childMethod(); // 컴파일 에러

        // Child poly3 = new Parent(); // 자식은 부모를 담을 수 없음
    }

}

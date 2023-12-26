package chap10;

public class CastingMain {

    public static void main(String[] args) {
        Parent poly = new Child();

        // 다운캐스팅
        Child child = (Child) poly;
        child.childMethod();

        // 일시적 다운캐스팅: 메서드 호출 순간만 다운캐스팅
        ((Child) poly).childMethod();

        // 업캐스팅
        Parent parent1 = (Parent) child;
        Parent parent2 = child; // 변환 타입 생략 권장

        parent1.parentMethod();
        parent2.parentMethod();
    }

}

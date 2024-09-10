package chap02.item04;

public class UtilityClass {

    private UtilityClass() {
        // 꼭 AssertionError를 던질 필요는 없지만
        // 실수로라도 생성자를 호출하지 않도록 막을 필요가 있다
        throw new AssertionError(this.getClass().getSimpleName() + "의 기본 생성자 호출이 불가능합니다.");
    }

    static class NestedUtilityClass extends UtilityClass {
        /* 생성자 생략 시 컴파일러가 아래와 같은 생성자를 만들어줌
        public NestedUtilityClass() {
            super();
        }*/
    }

    public static void main(String[] args) {
        try {
            new UtilityClass();
        } catch (AssertionError e) {
            // UtilityClass의 기본 생성자 호출이 불가능합니다.
            System.out.println(e.getMessage());
        }

        try {
            new NestedUtilityClass();
        } catch (AssertionError e) {
            // NestedUtilityClass의 기본 생성자 호출이 불가능합니다.
            System.out.println(e.getMessage());
        }
    }

}

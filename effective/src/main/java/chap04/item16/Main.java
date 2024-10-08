package chap04.item16;

public class Main {

    public static void main(String[] args) {
        Time time = new Time(10, 20);

        // 불변 필드는 공개 되어도 변경은 불가능하다
        // time.hour = 10;
        // 굳이 접근할 필요가 없는 필드를 공개해서는 안된다 -> 혼란의 가중
    }
}

package chap7.static_method;

public class DecoMain {

    public static void main(String[] args) {
        String str = "hello java";

        // 인스턴스 메서드
        Deco1 deco1 = new Deco1();
        System.out.println("인스턴스 메서드: " + deco1.deco(str));

        // 정적 메서드(클래스 메서드)
        System.out.println("정적(클래스) 메서드: " + Deco2.deco(str));

    }

}

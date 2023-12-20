package chap7.static_method;

public class DecoDataMain {

    public static void main(String[] args) {
        System.out.println("정적 메서드 호출");
        DecoData.staticCall();

        System.out.println("첫 번째 인스턴스 메서드 호출");
        DecoData decoData1 = new DecoData();
        decoData1.instanceCall();

        System.out.println("두 번째 인스턴스 메서드 호출");
        DecoData decoData2 = new DecoData();
        decoData2.instanceCall();
    }

}

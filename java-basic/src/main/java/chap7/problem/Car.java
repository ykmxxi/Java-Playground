package chap7.problem;

public class Car {

    private static int count;
    private final String name;

    public Car(final String name) {
        System.out.println("차량 구입, 이름: " + name);
        this.name = name;
        count++;
    }

    public static void showTotalCars() {
        System.out.println("구매한 차량 수: " + count);
    }

}

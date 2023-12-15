package deepcopy;

public class Car {

    private final String name;
    private int position;

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    // 복사 생성자
    public Car(final Car car) {
        this.name = car.name;
        this.position = car.position;
    }

}

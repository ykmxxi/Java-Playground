package chap9;

public class ElectricCar extends Car {

    @Override
    public void move() {
        System.out.println("전기차는 빠르게 움직입니다.");
    }

    public void charge() {
        System.out.println("충전합니다.");
    }

}

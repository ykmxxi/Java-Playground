package chap11.추상클래스;

public class Caw extends AbstractAnimal {

    @Override
    public void sound() {
        System.out.println("음메");
    }

    @Override
    public void move() {
        System.out.println("소 움직임");
    }

}

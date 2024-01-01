package chap11.추상클래스;

public class Dog extends AbstractAnimal {

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public void move() {
        System.out.println("강아지 움직임");
    }

}

package chap11.추상클래스;

public class Cat extends AbstractAnimal {

    @Override
    public void sound() {
        System.out.println("냐옹");
    }

    @Override
    public void move() {
        System.out.println("고양이 움직임");
    }

}

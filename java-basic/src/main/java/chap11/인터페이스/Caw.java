package chap11.인터페이스;

public class Caw implements InterfaceAnimal {

    @Override
    public void sound() {
        System.out.println("음메");
    }

    @Override
    public void move() {
        System.out.println("소가 움직입니다");
    }

}

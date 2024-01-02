package chap11.인터페이스;

public class Cat implements InterfaceAnimal{

    @Override
    public void sound() {
        System.out.println("냐옹");
    }

    @Override
    public void move() {
        System.out.println("고양이가 움직입니다.");
    }

}

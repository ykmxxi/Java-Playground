package chap11.상속과구현;

public abstract class Animal {

    public abstract void sound();

    public void move() {
        System.out.println("동물이 움직입니다.");
    }

}

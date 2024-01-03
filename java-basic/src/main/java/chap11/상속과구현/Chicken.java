package chap11.상속과구현;

public class Chicken extends Animal implements Fly {

    @Override
    public void sound() {
        System.out.println("꼬끼오");
    }

    @Override
    public void fly() {
        System.out.println("닭 날기");
    }

}

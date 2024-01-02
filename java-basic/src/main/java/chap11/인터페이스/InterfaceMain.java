package chap11.인터페이스;

public class InterfaceMain {

    public static void main(String[] args) {
        InterfaceAnimal[] animals = {new Cat(), new Caw(), new Dog()};

        for (InterfaceAnimal animal : animals) {
            soundAnimal(animal);
        }

        for (InterfaceAnimal animal : animals) {
            moveAnimal(animal);
        }
    }

    private static void soundAnimal(final InterfaceAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }

    private static void moveAnimal(final InterfaceAnimal animal) {
        System.out.println("동물 움직임 테스트 시작");
        animal.move();
        System.out.println("동물 움직임 테스트 종료");
    }

}

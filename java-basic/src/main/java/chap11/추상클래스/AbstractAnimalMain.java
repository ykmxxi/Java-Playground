package chap11.추상클래스;

public class AbstractAnimalMain {

    public static void main(String[] args) {
        // AbstractAnimal abstractAnimal = new AbstractAnimal(); // 컴파일 오류

        AbstractAnimal[] animals = {new Dog(), new Cat(), new Caw()};
        for (AbstractAnimal animal : animals) {
            soundAnimal(animal);
        }

        for (AbstractAnimal animal : animals) {
            moveAnimal(animal);
        }
    }

    private static void soundAnimal(final AbstractAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }

    private static void moveAnimal(final AbstractAnimal animal) {
        System.out.println("동물 움직임 테스트 시작");
        animal.move();
        System.out.println("동물 움직임 테스트 종료");
    }

}

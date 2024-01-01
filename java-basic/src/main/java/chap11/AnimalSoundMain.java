package chap11;

public class AnimalSoundMain {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        Animal[] animals = {dog, cat, caw};
        for (Animal animal : animals) {
            soundAnimal(animal);
        }
    }

    private static void soundAnimal(final Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }

}

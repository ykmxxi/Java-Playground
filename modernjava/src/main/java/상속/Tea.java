package 상속;

public class Tea {

    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }

    public void boilWater() {
        System.out.println("물을 끓인다");
    }

    public void steepTeaBag() {
        System.out.println("티백을 담근다");
    }

    public void pourInCup() {
        System.out.println("컵에 붓는다");
    }

    public void addLemon() {
        System.out.println("레몬을 추가한다");
    }

}

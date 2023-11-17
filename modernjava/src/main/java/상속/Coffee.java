package 상속;

public class Coffee extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println("필터를 활용해 커피를 내린다");
    }

    @Override
    public void addCondiments() {
        System.out.println("설탕과 우유를 추가한다");
    }

}

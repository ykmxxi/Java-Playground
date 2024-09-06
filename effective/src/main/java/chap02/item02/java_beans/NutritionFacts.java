package chap02.item02.java_beans;

/*
    - JavaBeans 패턴
    - 가독성이 좋으나 불변 클래스를 만들지 못하고, 객체가 완전히 생성되기 전까지 일관성(consistency)이 무너진 상태
    - 매개변수가 많으면 많은 setter 메서드를  호출해야 한다
 */
public class NutritionFacts {

    private int servingSize;      // 필수
    private int servings;         // 필수
    private int calories = 0;     // 선택
    private int fat = 0;          // 선택
    private int sodium = 0;       // 선택
    private int carbohydrate = 0; // 선택

    public NutritionFacts() {}

    public void setServingSize(final int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(final int servings) {
        this.servings = servings;
    }

    public void setCalories(final int calories) {
        this.calories = calories;
    }

    public void setFat(final int fat) {
        this.fat = fat;
    }

    public void setSodium(final int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(final int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

}

package chap02.item02.telescoping;

/*
    - 점층적 생성자(Telescoping constructor) 패턴
    - 선택적 매개변수가 많을수록 확장이 어려움
    - 매개변수가 많으면 많은 setter 메서드를  호출해야 한다
 */
public class NutritionFacts {

    private final int servingSize;  // 필수
    private final int servings;     // 필수
    private final int calories;     // 선택
    private final int fat;          // 선택
    private final int sodium;       // 선택
    private final int carbohydrate; // 선택

    public NutritionFacts(final int servingSize, final int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(final int servingSize, final int servings, final int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(final int servingSize, final int servings, final int calories, final int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(final int servingSize, final int servings, final int calories, final int fat,
                          final int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(final int servingSize, final int servings, final int calories, final int fat,
                          final int sodium, final int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }

}

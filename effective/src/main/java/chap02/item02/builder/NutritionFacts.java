package chap02.item02.builder;

/*
    - Builder pattern
    - 점층적 생성자 패턴의 안전성 + JavaBeans 패턴의 가독성을 겸비한 객체 생성 패턴
    - 매개변수가 많으면 많은 setter 메서드를  호출해야 한다
 */
public class NutritionFacts {

    private final int servingSize;  // 필수
    private final int servings;     // 필수
    private final int calories;     // 선택
    private final int fat;          // 선택
    private final int sodium;       // 선택
    private final int carbohydrate; // 선택

    public static class Builder {

        private final int servingSize;  // 필수
        private final int servings;     // 필수

        private int calories = 0;     // 선택
        private int fat = 0;          // 선택
        private int sodium = 0;       // 선택
        private int carbohydrate = 0; // 선택

        public Builder(final int servingSize, final int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(final int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(final int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(final int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(final int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }

    }

    private NutritionFacts(final Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

}

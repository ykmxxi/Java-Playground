package chap02.item02;

import chap02.item02.builder.NutritionFacts;

public class Main {

    public static void main(String[] args) {
        NutritionFacts.Builder builder = new NutritionFacts.Builder(10, 10);
        NutritionFacts nutritionFacts = builder.fat(10)
                .calories(100)
                .carbohydrate(1)
                .sodium(1)
                .build();
    }

}

package 추상화.추상클래스;

public class ChristmasDiscount extends Discount {

    private static final int DEFAULT_DISCOUNT_AMOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREMENT = 100;

    public ChristmasDiscount(final int totalOrderAmount, final int visitDay) {
        super(totalOrderAmount, visitDay);
    }

    @Override
    public boolean canApply() {
        return super.canApply() && isBeforeChristmas(getVisitDay());
    }

    private boolean isBeforeChristmas(final int visitDay) {
        return visitDay <= 25;
    }

    @Override
    int calculateDiscountAmount() {
        if (canApply()) {
            return (getVisitDay() - 1) * DAILY_DISCOUNT_INCREMENT + DEFAULT_DISCOUNT_AMOUNT;
        }
        return 0;
    }

    @Override
    int calculateDiscountAmount(final String menuType) {
        return 0;
    }

}

package 추상화.추상클래스;

import java.time.LocalDate;

public abstract class Discount {

    private static final int EVENT_MINIMUM_CONDITION = 10_000;
    private static final LocalDate START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate END_DATE = LocalDate.of(2023, 12, 31);

    private final int totalOrderAmount;
    private final int visitDay;

    Discount(final int totalOrderAmount, final int visitDay) {
        this.totalOrderAmount = totalOrderAmount;
        this.visitDay = visitDay;
    }

    abstract int calculateDiscountAmount();

    abstract int calculateDiscountAmount(final String menuType);

    public boolean canApply() {
        return isOverMinimumOrderAmount() && isDiscountPeriod();
    }

    private boolean isOverMinimumOrderAmount() {
        return totalOrderAmount >= EVENT_MINIMUM_CONDITION;
    }

    private boolean isDiscountPeriod() {
        LocalDate visitDate = LocalDate.of(2023, 12, visitDay);
        return isBetweenStartDateAndEndDate(visitDate);
    }

    private boolean isBetweenStartDateAndEndDate(final LocalDate visitDate) {
        return isAfterOrEqual(visitDate) && isBeforeOrEqual(visitDate);
    }

    private boolean isAfterOrEqual(final LocalDate visitDate) {
        return visitDate.isAfter(START_DATE) || visitDate.isEqual(START_DATE);
    }

    private boolean isBeforeOrEqual(final LocalDate visitDate) {
        return visitDate.isBefore(END_DATE) || visitDate.isEqual(END_DATE);
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public int getVisitDay() {
        return visitDay;
    }

}

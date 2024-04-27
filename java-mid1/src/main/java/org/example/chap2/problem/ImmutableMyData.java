package org.example.chap2.problem;

public class ImmutableMyData {

    private final int year;
    private final int month;
    private final int day;

    public ImmutableMyData(final int year, final int month, final int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 불변 객체의 값을 변경하는 메소드는 관례상 withXxx 명명
    public ImmutableMyData withYear(final int newYear) {
        return new ImmutableMyData(newYear, month, day);
    }

    public ImmutableMyData withMonth(final int newMonth) {
        return new ImmutableMyData(year, newMonth, day);
    }

    public ImmutableMyData withDay(final int newDay) {
        return new ImmutableMyData(year, month, newDay);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

}

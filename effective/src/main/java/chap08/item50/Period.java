package chap08.item50;

import java.util.Date;

public final class Period {

    private final Date start;
    private final Date end;

    // 매개변수의 방어적 복사본을 만든다
    public Period(final Date start, final Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + "가 " + this.end + "보다 늦다.");
        }
    }

    // 필드의 방어적 복사본을 반환한다
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return start + " - " + end;
    }

}

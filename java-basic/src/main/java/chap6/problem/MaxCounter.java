package chap6.problem;

public class MaxCounter {

    private int count;
    private int max;

    public MaxCounter(final int max) {
        this.count = 0;
        this.max = max;
    }

    public void increment() {
        if (validateCount()) {
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }
        count++;
    }

    private boolean validateCount() {
        return count >= max;

    }

    public int getCount() {
        return count;
    }

}

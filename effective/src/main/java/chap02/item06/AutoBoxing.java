package chap02.item06;

public class AutoBoxing {

    public static long sum1() {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sum2() {
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        sum1();
        long end = System.currentTimeMillis();
        System.out.println("오토 박싱 O: " + (end - start) + "ms"); // 약 5.83초

        start = System.currentTimeMillis();
        sum2();
        end = System.currentTimeMillis();
        System.out.println("오토 박싱 X: " + (end - start) + "ms"); // 약 0.68초
    }

}

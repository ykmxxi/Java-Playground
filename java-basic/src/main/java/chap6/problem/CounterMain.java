package chap6.problem;

public class CounterMain {

    public static void main(String[] args) {
        MaxCounter counter = new MaxCounter(3);
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        System.out.println(counter.getCount());
    }

}

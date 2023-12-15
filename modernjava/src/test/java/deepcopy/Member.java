package deepcopy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private final String name;
    private final int age;
    private final List<Integer> numbers = new ArrayList<>();

    public Member(final String name, final int age) {
        this.name = name;
        this.age = age;
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    public void add(final int number) {
        numbers.add(number);
    }

    public int getRef() {
        return System.identityHashCode(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}

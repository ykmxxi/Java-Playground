package org.example.oop.composition;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void lottoMethod() {
        System.out.println("Lotto.lottoMethod");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int calculateCountOfMatching(final Lotto otherLotto) {
        return (int) otherLotto.numbers.stream()
                .filter(this::has)
                .count();
    }

    public boolean has(final int number) {
        return numbers.contains(number);
    }

}

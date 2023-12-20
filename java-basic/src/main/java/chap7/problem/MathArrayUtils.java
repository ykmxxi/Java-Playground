package chap7.problem;

import java.util.Arrays;

public class MathArrayUtils {

    private MathArrayUtils() {
    }

    public static int sum(final int[] array) {
        return Arrays.stream(array)
                .sum();
    }

    public static double average(final int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException();
        }
        return (double) sum(array) / array.length;
    }

    public static int min(final int[] array) {
        return Arrays.stream(array)
                .min()
                .orElseThrow();
    }

    public static int max(final int[] array) {
        return Arrays.stream(array)
                .max()
                .orElseThrow();
    }

}

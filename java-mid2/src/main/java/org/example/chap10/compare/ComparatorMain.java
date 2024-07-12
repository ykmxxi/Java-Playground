package org.example.chap10.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorMain {

    public static void main(String[] args) {
        Integer[] array = {2, 3, 1};

        System.out.println(Arrays.toString(array));

        System.out.println("오름차순 정렬");
        Arrays.sort(array, new AscComparator());
        System.out.println(Arrays.toString(array));

        System.out.println("내림차순 정렬");
        Arrays.sort(array, new DescComparator());
        System.out.println(Arrays.toString(array));

        // 오름차순만 정렬하고 Comparator.reversed()를 사용해도 내림차순 가능
        System.out.println("내림차순 정렬: Comparator.reversed()");
        Arrays.sort(array, new AscComparator().reversed());
        System.out.println(Arrays.toString(array));
    }

    static class AscComparator implements Comparator<Integer> {

        @Override
        public int compare(final Integer o1, final Integer o2) {
            System.out.println("o1 = " + o1 + ", o2 = " + o2);
            return o1 - o2;
        }

    }

    static class DescComparator implements Comparator<Integer> {

        @Override
        public int compare(final Integer o1, final Integer o2) {
            System.out.println("o1 = " + o1 + ", o2 = " + o2);
            return o2 - o1;
        }

    }

}

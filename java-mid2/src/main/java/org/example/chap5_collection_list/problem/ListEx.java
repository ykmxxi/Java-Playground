package org.example.chap5_collection_list.problem;

import java.util.Arrays;
import java.util.List;

public class ListEx {

    public static void main(String[] args) {
        int[] arr = {90, 80, 70, 60, 50};

        List<Integer> students = Arrays.stream(arr)
                .boxed()
                .toList();

        int total = 0;
        for (int student : students) {
            total += student;
        }

        double avg = (double) students.stream()
                .mapToInt(Integer::intValue)
                .sum() / students.size();
        System.out.println("total = " + total + ", avg = " + avg);

    }

}

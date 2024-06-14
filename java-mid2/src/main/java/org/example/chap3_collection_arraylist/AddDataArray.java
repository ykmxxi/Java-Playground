package org.example.chap3_collection_arraylist;

import java.util.Arrays;

public class AddDataArray {

    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        System.out.println(Arrays.toString(arr));

        // 배열의 첫 번째 위치에 데이터 추가
        System.out.println("배열의 첫 번쨰 위치에 데이터 추가: O(n)");
        addFirst(3, arr);
        System.out.println(Arrays.toString(arr));

        // 배열의 중간 index에 데이터 추가
        System.out.println("배열의 중간 위치에 데이터 추가: O(n)");
        addAtIndex(2, 4, arr);
        System.out.println(Arrays.toString(arr));

        // 배열의 마지막 위치에 데이터 추가
        System.out.println("배열의 마지막 위치에 데이터 추가: O(1)");
        addLast(5, arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void addFirst(final int value, final int[] arr) {
        // 제일 마지막 인덱스부터 왼쪽 데이터를 가져오기, 즉 한 칸씩 오른쪽으로 밀기
        for (int idx = arr.length - 1; idx > 0; idx--) {
            arr[idx] = arr[idx - 1];
        }
        arr[0] = value;
    }

    private static void addAtIndex(final int index, final int value, final int[] arr) {
        // 해당 index의 오른쪽에 있는 데이터를 모두 한 칸씩 이동
        for (int idx = arr.length - 1; idx > index; idx--) {
            arr[idx] = arr[idx - 1];
        }
        arr[index] = value;
    }

    private static void addLast(final int value, final int[] arr) {
        arr[arr.length - 1] = value;
    }

}

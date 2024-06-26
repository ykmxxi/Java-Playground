package org.example.chap6_collection_hash;

import java.util.Arrays;

/**
 * Hash Algorithm: index 적용
 * 데이터 검색 시간 복잡도: O(1)
 * 단, 입력 범위에 따라 배열 메모리 낭비가 심해짐
 */
public class HashStart2 {

    public static void main(String[] args) {
        Integer[] inputArray = new Integer[10];
        inputArray[1] = 1;
        inputArray[2] = 2;
        inputArray[5] = 5;
        inputArray[8] = 8;
        System.out.println(Arrays.toString(inputArray));

        int searchValue = 8;

        // O(1)
        if (inputArray[searchValue] != null) {
            System.out.println("searchValue = " + searchValue);
        }
    }

}

package org.example.chap6_collection_hash;

/**
 * Hash Algorithm: for문 데이터 검색
 * 데이터 검색 시간 복잡도: O(n)
 */
public class HashStart1 {

    public static void main(String[] args) {
        Integer[] inputArray = new Integer[4];
        inputArray[0] = 1;
        inputArray[1] = 2;
        inputArray[2] = 5;
        inputArray[3] = 8;

        int searchValue = 8;

        // O(n)
        for (Integer value : inputArray) {
            if (value == searchValue) {
                System.out.println("searchValue = " + searchValue);
            }
        }
    }

}

package org.example.chap9.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("==단어 입력 단계==");
        while (true) {
            System.out.print("영어 단어를 입력하세요 (종료는 'q'): ");
            String engWord = sc.nextLine();
            if (isExit(engWord)) {
                break;
            }
            System.out.print("한글 뜻을 입력하세요: ");
            String krWord = sc.nextLine();

            dictionary.put(engWord, krWord);
        }

        System.out.println();

        System.out.println("==단어 검색 단계==");
        while (true) {
            System.out.print("찾을 영어 단어를 입력하세요: ");
            String searchWord = sc.nextLine();
            if (isExit(searchWord)) {
                break;
            }
            if (dictionary.containsKey(searchWord)) {
                System.out.println(searchWord + "의 뜻: " + dictionary.get(searchWord));
                continue;
            }
            System.out.println(searchWord + "은(는) 사전에 없는 단어입니다.");
        }
    }

    private static boolean isExit(final String input) {
        return input.equals("q");
    }

}

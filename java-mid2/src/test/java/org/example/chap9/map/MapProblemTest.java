package org.example.chap9.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapProblemTest {

    @Test
    @DisplayName("2차원 배열의 데이터를 Map 전환")
    void problem1() {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

        Map<String, Integer> productMap = Arrays.stream(productArr)
                .collect(Collectors.toMap(
                        arr -> arr[0],
                        arr -> Integer.valueOf(arr[1]))
                );
        for (String key : productMap.keySet()) {
            System.out.println("제품: " + key + ", 가격: " + productMap.get(key));
        }
    }

    @Test
    @DisplayName("map1, map2 공통 키를 찾고, 그 값의 합을 구한다")
    void problem2() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 4);
        map2.put("C", 5);
        map2.put("D", 6);

        Set<String> intersectionKey = map1.keySet();
        intersectionKey.retainAll(map2.keySet());

        Map<String, Integer> intersectionMap = new HashMap<>();
        for (String key : intersectionKey) {
            intersectionMap.put(key, map1.get(key) + map2.get(key));
        }
        System.out.println("intersectionMap = " + intersectionMap);
    }

    @Test
    @DisplayName("같은 단어가 나타난 수를 출력")
    void problem3() {
        String text = "orange banana apple apple banana apple";

        Map<String, Integer> map = new HashMap<>();
        for (String word : text.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
    }

    @Test
    @DisplayName("Map에 들어있는 데이터 중에 값이 1000원인 모든 상품을 출력")
    void problem4() {
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000);

        List<String> result = map.keySet()
                .stream()
                .filter(key -> map.get(key) == 1000)
                .toList();
        System.out.println(result);
    }

}

package org.example.chap9.map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.jupiter.api.Test;

class MapTest {

    @Test
    void hashMapBasicTest() {
        Map<String, Integer> studentMap = new HashMap<>();
        addData(studentMap);

        Set<String> keySet = studentMap.keySet();
        Collection<Integer> values = studentMap.values();
        assertThat(keySet.size()).isEqualTo(4);
        assertThat(values.size()).isEqualTo(4);
        System.out.println("keySet = " + keySet);
        System.out.println("values = " + values);
        for (String key : keySet) {
            System.out.println("key = " + key + ", value = " + studentMap.get(key));
        }
        System.out.println();

        Set<Entry<String, Integer>> entries = studentMap.entrySet();
        assertThat(entries.size()).isEqualTo(4);
        for (Entry<String, Integer> entry : entries) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
    }

    @Test
    void hashMap_중복저장() {
        Map<String, Integer> studentMap = new HashMap<>();
        addData(studentMap);

        // studentA의 정보가 존재하는 상황
        String key = "studentA";
        assertThat(studentMap.containsKey(key)).isTrue();
        assertThat(studentMap.get(key)).isEqualTo(90);

        // 같은 key로 저장하면 나중에 들어온 값이 저장된다
        studentMap.put(key, 100);
        assertThat(studentMap.get(key)).isEqualTo(100);

        // 중복 저장 방지 1: if 문 key 존재 여부 확인 후 저장
        int newScore = 50;
        if (!studentMap.containsKey(key)) {
            studentMap.put(key, newScore);
        }
        assertThat(studentMap.get(key)).isEqualTo(100);

        // 중복 저장 방지 2: putIfAbsent() 활용
        studentMap.putIfAbsent(key, newScore);
        studentMap.putIfAbsent("studentZ", newScore);
        assertThat(studentMap.get(key)).isEqualTo(100);
        assertThat(studentMap.get("studentZ")).isEqualTo(50);
    }

    private void addData(final Map<String, Integer> studentMap) {
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 100);
    }

}

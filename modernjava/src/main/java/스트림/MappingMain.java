package 스트림;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class MappingMain {

    public static void main(String[] args) {
        List<String> words = List.of("Hello", "World");

        words.stream()
             .map(word -> word.split(""))
             .flatMap(Arrays::stream)
             .distinct()
             .forEach(System.out::print);
        System.out.println("words = " + words);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> squareNumbers = numbers.stream()
                                             .map(n -> n * n)
                                             .collect(toList());
        System.out.println("squareNumbers = " + squareNumbers);

        // 두 개의 리스트가 있을 때 모든 숫자 쌍의 리스트 반환
        // ex: [1, 2, 3], [3,4] -> [(1, 3), (1, 4), ..., (3, 3), (3, 4)]
        List<Integer> numbers1 = List.of(1, 2, 3);
        List<Integer> numbers2 = List.of(3, 4);

        List<Integer[]> pairs = numbers1.stream()
                                        .flatMap(n1 -> numbers2.stream()
                                                               .map(n2 -> new Integer[] {n1, n2}))
                                        .collect(toList());
        for (Integer[] pair : pairs) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }

        // 합이 3으로 나누어떨어지는 쌍만 반환
        List<Integer[]> pairs2 = numbers1.stream()
                                         .flatMap(n1 -> numbers2.stream()
                                                                .filter(n2 -> (n1 + n2) % 3 == 0)
                                                                .map(n2 -> new Integer[] {n1, n2}))
                                         .collect(toList());
        for (Integer[] pair : pairs2) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }

    }

}

package chap10.item69;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ExceptionHandling {

    private int[] num = new int[10];

    // 예외를 완전히 잘못 사용한 예
    public void wrongException() {
//        try {
//            int i = 0;
//            while (true) {
//                num[i] = i;
//                i++;
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//
//        }
    }

    // 정상 흐름에서 예외를 사용할 일이 없게 만든다
    public void normalFlow() {
        List<String> list = new ArrayList<>();

        for (String next : list) {
            // ... 정상 흐름
        }
    }

    // try-catch 사용 순회는 최악
    public void tryCatchIter() {
        List<String> list = new ArrayList<>();
        
        try {
            Iterator<String> iterator = list.iterator();

            while (true) {
                String next = iterator.next();
                // 정상 흐름 처리
            }
        } catch (NoSuchElementException e) {

        }
    }

}

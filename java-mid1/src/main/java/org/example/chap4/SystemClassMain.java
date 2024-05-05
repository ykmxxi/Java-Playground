package org.example.chap4;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class SystemClassMain {

    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        long currentNanoTime = System.nanoTime();
        System.out.println("currentNanoTime = " + currentNanoTime);

        // 환경 변수: OS가 사용
        Map<String, String> envs = System.getenv();
        for (String key : envs.keySet()) {
            System.out.println("key = " + key + ", value = " + envs.get(key));
        }

        // 시스템 속성: Java가 사용
        Properties properties = System.getProperties();
        System.out.println("properties = " + properties);
        String javaVersion = System.getProperty("java.version");
        System.out.println("javaVersion = " + javaVersion);

        // 배열 고속 복사, 반복문을 돌려 복사하는 방법 보다 훨씬 빠름
        char[] original = {'h', 'e', 'l', 'l', 'o'};
        char[] copy = new char[original.length];
        System.arraycopy(original, 0, copy, 0, original.length);
        System.out.println("original = " + Arrays.toString(original));
        System.out.println("copy = " + Arrays.toString(copy));

        // 시스템 종료
        System.exit(0); // 정상 종료

        System.out.println("정상 종료되어 출력이 안돼요.");
    }

}

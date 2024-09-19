package chap02.item06;

import java.util.regex.Pattern;

public class PhoneNumber {

    private static final Pattern PHONE = Pattern.compile("^\\\\d{3}-\\\\d{3,4}-\\\\d{4}$");

    public static boolean isValid1(String input) {
        return PHONE.matcher(input)
                .matches();
    }

    public static boolean isValid2(String input) {
        return input.matches("^\\\\d{3}-\\\\d{3,4}-\\\\d{4}$");
    }

    public static void main(String[] args) {
        int cnt = 10_000;

        long start = System.currentTimeMillis();
        for (int i = 0; i < cnt; i++) {
            isValid1("010-1234-5678");
        }
        long end = System.currentTimeMillis();
        System.out.println("객체 재사용 메서드: " + (end - start) +"ms"); // 5ms

        start = System.currentTimeMillis();
        for (int i = 0; i < cnt; i++) {
            isValid2("010-1234-5678");
        }
        end = System.currentTimeMillis();
        System.out.println("호출 시 객체 생성: " + (end - start) +"ms"); // 48ms
    }

}

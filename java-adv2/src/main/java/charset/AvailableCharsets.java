package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsets {

    public static void main(String[] args) {
        // 이용 가능한 모든 Charset(Java + OS)
        SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
        availableCharsets.keySet()
                .forEach((charset) -> System.out.println("CharsetName = " + charset));

        System.out.println("=====");

        // 문자로 조회(대소문자 구분 X): ms949, MS949 가능
        Charset ms949 = Charset.forName("ms949");
        Charset utf16 = Charset.forName("utf_16");
        System.out.println("ms949 = " + ms949);
        System.out.println("utf16 = " + utf16);

        // 별칭 조회
        Set<String> ms949Aliases = ms949.aliases();
        Set<String> utf16Aliases = utf16.aliases();
        System.out.println("ms949Aliases = " + ms949Aliases);
        System.out.println("utf16Aliases = " + utf16Aliases);

        // UTF-8 조회: 상수 조회
        Charset utf8 = StandardCharsets.UTF_8;
        System.out.println("utf8 = " + utf8);

        // System 기본 Charset
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset = " + defaultCharset);
    }

}

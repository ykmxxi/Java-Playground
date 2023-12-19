package chap7.static_method;

public class Deco2 {

    public static String deco(final String str) {
        return String.join("", "*", String.join("", str, "*"));
    }

}

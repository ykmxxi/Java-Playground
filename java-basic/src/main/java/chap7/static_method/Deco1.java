package chap7.static_method;

public class Deco1 {

    public String deco(final String str) {
        return String.join("", "*", String.join("", str, "*"));
    }

}

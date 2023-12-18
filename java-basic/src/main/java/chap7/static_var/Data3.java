package chap7.static_var;

public class Data3 {

    public static int count;

    public String name;

    public Data3(final String name) {
        this.name = name;
        count++;
    }

}

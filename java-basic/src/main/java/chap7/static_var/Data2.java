package chap7.static_var;

public class Data2 {

    public String name;

    public Data2(final String name, final Counter counter) {
        this.name = name;
        counter.count++;
    }

}

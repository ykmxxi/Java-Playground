package chap03.item14;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(final String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CaseInsensitiveString that)) {
            return false;
        }
        return that.s.equalsIgnoreCase(s);
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public String toString() {
        return s;
    }

    public int compareTo(final CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }

    public static void main(String[] args) {
        List<CaseInsensitiveString> words = List.of(new CaseInsensitiveString("hi"),
                new CaseInsensitiveString("HI"),
                new CaseInsensitiveString("Hi"),
                new CaseInsensitiveString("hI"));
        Set<CaseInsensitiveString> set = new HashSet<>();
        for (CaseInsensitiveString cis : words) {
            set.add(cis);
        }
        System.out.println(set);
    }

}

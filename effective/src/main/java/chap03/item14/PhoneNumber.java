package chap03.item14;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public final class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

    private final int areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private int rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return val;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhoneNumber that)) {
            return false;
        }
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d",
                areaCode, prefix, lineNum);
    }

    private static final Comparator<PhoneNumber> COMPARATOR =
            comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    @Override
    public int compareTo(final PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }

    private static PhoneNumber randomPhoneNumber() {
        Random rnd = ThreadLocalRandom.current();
        return new PhoneNumber((short) rnd.nextInt(1000),
                (short) rnd.nextInt(1000),
                (short) rnd.nextInt(10000));
    }

    public static void main(String[] args) {
        NavigableSet<PhoneNumber> s = new TreeSet<PhoneNumber>();
        for (int i = 0; i < 10; i++) {
            s.add(randomPhoneNumber());
        }
        System.out.println(s);
    }

}

package chap03.item13;

import java.util.HashMap;
import java.util.Map;

public final class PhoneNumber implements Cloneable {

    private final int frontNum;
    private final int midNum;
    private final int lastNum;

    public PhoneNumber(final int frontNum, final int midNum, final int lastNum) {
        this.frontNum = rangeCheck(frontNum, 999, "앞자리");
        this.midNum = rangeCheck(midNum, 9999, "중간 번호");
        this.lastNum = rangeCheck(lastNum, 9999, "끝 번호");
    }

    private int rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber pn)) {
            return false;
        }
        return pn.lastNum == lastNum && pn.midNum == midNum
                && pn.frontNum == frontNum;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(frontNum);
        result = 31 * result + Integer.hashCode(midNum);
        result = 31 * result + Integer.hashCode(lastNum);
        return result;
    }

    /**
     * 이 전화번호의 문자열 표현을 반환
     */
    @Override
    public String toString() {
        return String.format("%03d-%04d-%04d", frontNum, midNum, lastNum);
    }

    @Override
    protected PhoneNumber clone() {
        try {
            // Object.clone()은 Object 반환, 공변 반환 타입(covariant return typing) 지원
            // 캐스팅해서 반환하는 것을 권장
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // 일어날 수 없는 일
        }
    }

    public static void main(String[] args) {
        PhoneNumber kim = new PhoneNumber(10, 1234, 5678);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(kim, "Kim");
        System.out.println("Kim clone 맵에 존재하나? " + m.get(kim.clone()));
    }

}

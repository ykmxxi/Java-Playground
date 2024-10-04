package chap03.item12;

public final class PhoneNumber {

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
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) o;
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

    public static void main(String[] args) {
        PhoneNumber kim = new PhoneNumber(10, 1234, 5678);
        // toString() 미구현: package.ClassName@주소
        // chap03.item12.PhoneNumber@194ca
        System.out.println("Kim의 번호: " + kim);
    }

}

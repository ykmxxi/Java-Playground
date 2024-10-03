package chap03.item11;

public class PhoneNumber3 {

    private final int areaCode;
    private final int prefix;
    private final int lineNum;
    private int hash;

    public PhoneNumber3(final int areaCode, final int prefix, final int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
        this.hash = hashCode(); // Hash의 key로 자주 사용되는 경우 미리 계산해 저장
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber3 p)) {
            return false;
        }
        return p.areaCode == areaCode && p.prefix == prefix && p.lineNum == lineNum;
    }

    @Override
    public int hashCode() {
        int result = hash;
        if (result == 0) {
            result = Integer.hashCode(areaCode);
            result = 31 * result * Integer.hashCode(prefix);
            result = 31 * result * Integer.hashCode(lineNum);
            hash = result;
        }
        return result;
    }

}

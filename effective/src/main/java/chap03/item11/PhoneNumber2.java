package chap03.item11;

public class PhoneNumber2 {

    private final int areaCode;
    private final int prefix;
    private final int lineNum;

    public PhoneNumber2(final int areaCode, final int prefix, final int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber2 p)) {
            return false;
        }
        return p.areaCode == areaCode && p.prefix == prefix && p.lineNum == lineNum;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(areaCode);
        result = 31 * result * Integer.hashCode(prefix);
        result = 31 * result * Integer.hashCode(lineNum);
        return result;

        // IDE 자동 구현 코드
        // Objects.hash()도 위 과정처럼 31 소수 사용해 핵심 필드들을 계산
        // return Objects.hash(areaCode, prefix, lineNum);
    }

}

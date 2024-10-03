package chap03.item11;

public class PhoneNumber1 {

    private final int areaCode;
    private final int prefix;
    private final int lineNum;

    public PhoneNumber1(final int areaCode, final int prefix, final int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber1 p)) {
            return false;
        }
        return p.areaCode == areaCode && p.prefix == prefix && p.lineNum == lineNum;
    }

}

package chap12.problem2.pay;

public enum PayType {

    KAKAO("kakao"),
    NAVER("naver");

    private final String name;

    PayType(final String name) {
        this.name = name;
    }

    public static Pay findPayment(final String option) {
        for (PayType value : PayType.values()) {
            if (KAKAO.name.equals(option)) {
                return new KakaoPay();
            }
            if (NAVER.name.equals(option)) {
                return new NaverPay();
            }
        }
        return new DefaultPay();
    }

}

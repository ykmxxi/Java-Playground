package chap12.problem2.pay;

import java.util.Arrays;

public enum PayType {

    KAKAO("kakao", new KakaoPay()),
    NAVER("naver", new NaverPay()),
    TOSS("toss", new TossPay());

    private final String name;
    private final Pay pay;

    PayType(final String name, final Pay pay) {
        this.name = name;
        this.pay = pay;
    }

    public static Pay findPayment(final String option) {
        return Arrays.stream(PayType.values())
                .filter(payType -> payType.name.equals(option))
                .findFirst()
                .map(payType -> payType.pay)
                .orElse(new DefaultPay());
    }

}

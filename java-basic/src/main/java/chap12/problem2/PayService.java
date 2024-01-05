package chap12.problem2;

import chap12.problem2.pay.Pay;
import chap12.problem2.pay.PayType;

public class PayService {

    public void processPay(final String option, final int amount) {
        System.out.println("결제를 시작합니다: option=" + option + ", amount=" + amount);

        Pay pay = PayType.findPayment(option);
        boolean result = isSuccess(pay, amount);

        if (result) {
            System.out.println("결제가 성공했습니다.");
            return;
        }
        System.out.println("결제가 실패했습니다.");
    }

    private boolean isSuccess(final Pay pay, final int amount) {
        return pay.pay(amount);
    }

}

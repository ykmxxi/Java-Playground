package chap12.problem2;

import java.io.IOException;

import chap12.problem2.view.InputView;

/**
 * OCP 원칙 지키기
 * 메서드를 포함한 모든 코드 변경 가능(인터페이스 or 클래스 추가 가능)
 * 단, PayMain 코드는 변경하지 않고 그대로 유지해야 한다
 * 사용자 입력을 받는다
 */
public class PayMain {

    public static void main(String[] args) throws IOException {
        PayService payService = new PayService();

        while (true) {
            String option = InputView.readPay();
            if (isExit(option)) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            int amount = InputView.readAmount();

            payService.processPay(option, amount);
        }
    }

    private static boolean isExit(final String option) {
        return "exit".equals(option);
    }

}

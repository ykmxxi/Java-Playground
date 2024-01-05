package chap12.problem2.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String readPay() throws IOException {
        System.out.print("결제 수단을 입력하세요:");
        return br.readLine();
    }

    public static int readAmount() throws IOException {
        System.out.print("결제 금액을 입력하세요:");
        return Integer.parseInt(br.readLine());
    }

}

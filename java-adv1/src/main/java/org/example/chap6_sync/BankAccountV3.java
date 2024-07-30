package org.example.chap6_sync;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount {

    private int balance;

    public BankAccountV3(final int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(final int amount) {
        log("거래 시작: " + this.getClass().getSimpleName());

        // 블록 동기화
        // == 임계 영역 시작 ==
        synchronized (this) {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1_000L);
            balance -= amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
        }
        // == 임계 영역 종료 ==
        log("거래 종료");
        return true;
    }

    @Override
    public synchronized int getBalance() { // 메서드 동기화
        return balance;
    }

}

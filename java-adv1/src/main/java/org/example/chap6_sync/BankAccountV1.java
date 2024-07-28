package org.example.chap6_sync;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import org.example.chap6_sync.BankAccount;

public class BankAccountV1 implements BankAccount {

    private int balance;

    public BankAccountV1(final int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(final int amount) {
        log("거래 시작: " + this.getClass().getSimpleName());

        log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
        if (balance < amount) {
            log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
            return false;
        }
        log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
        sleep(1_000L);
        balance -= amount;
        log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }

}

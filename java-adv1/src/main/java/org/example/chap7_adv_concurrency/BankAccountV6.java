package org.example.chap7_adv_concurrency;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.example.chap6_sync.BankAccount;

public class BankAccountV6 implements BankAccount {

    private final Lock lock = new ReentrantLock();
    private int balance;

    public BankAccountV6(final int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(final int amount) {
        log("거래 시작: " + this.getClass().getSimpleName());

        try {
            if (!lock.tryLock(500L, TimeUnit.MILLISECONDS)) { // 500ms 대기
                log("[진입 실패] 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            // == 임계 영역 시작 ==
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1_000L);
            balance -= amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
            // == 임계 영역 종료 ==
        } finally {
            lock.unlock(); // 반드시 unlock() 호출, 호출하지 않으면 무한 대기
        }
        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }

}

package org.example.chap6_sync;

public class WithdrawTask implements Runnable {

    private final BankAccount account;
    private final int amount;

    public WithdrawTask(final BankAccount account, final int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }

}

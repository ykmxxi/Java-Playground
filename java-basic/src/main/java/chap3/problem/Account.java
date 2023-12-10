package chap3.problem;

public class Account {

    private int balance;

    public void deposit(final int amount) {
        balance += amount;
        System.out.println("계좌에 " + amount + "원 입금, 현재 잔액은 " + balance + "원 입니다.");
    }

    public void withdraw(final int amount) {
        if (balance < amount) {
            System.out.println("잔액 부족");
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원 출금, 현재 잔액은 " + balance + "원 입니다.");
        }
    }

}

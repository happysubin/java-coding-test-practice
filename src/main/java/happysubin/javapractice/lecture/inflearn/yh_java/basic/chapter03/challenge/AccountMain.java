package happysubin.javapractice.lecture.inflearn.yh_java.basic.chapter03.challenge;

public class AccountMain {

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(10000);
        account.withdraw(9000);
        account.withdraw(2000);
        System.out.println("잔고: " + account.getBalance());
    }
}

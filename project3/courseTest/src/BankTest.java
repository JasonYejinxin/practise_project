public class BankTest extends Thread{
    private static int balance;
    public double getBalance() {
        return balance;
    }
    public void addBalance(int balance) {
        this.balance += balance;
    }

    public void run(){
        show();
    }
    public static synchronized void show(){
        balance += 1000;
        System.out.println(Thread.currentThread().getName() + balance);
        balance += 1000;
        System.out.println(Thread.currentThread().getName() + balance);
        balance += 1000;
        System.out.println(Thread.currentThread().getName() + balance);
    }
}
class ThreadBankTest{
    public static void main(String[] args) {
        BankTest test1 = new BankTest();
        BankTest test2 = new BankTest();
        test1.setName("用户一");
        test2.setName("用户二");

        test1.start();
        test2.start();

    }
}

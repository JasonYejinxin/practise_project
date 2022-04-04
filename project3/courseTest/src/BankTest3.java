import java.util.concurrent.locks.ReentrantLock;

public class BankTest3 implements Runnable{
    private int balance;
    private ReentrantLock lock = new ReentrantLock();
    public int getBalance() {
        return balance;
    }
    public void addBalance(int balance) {
        this.balance += balance;
    }
    public void run() {
        lock.lock();
        try {
            addBalance(1000);
            System.out.println(Thread.currentThread().getName() + ":" + getBalance());
            addBalance(1000);
            System.out.println(Thread.currentThread().getName() + ":" + getBalance());
            addBalance(1000);
            System.out.println(Thread.currentThread().getName() + ":" + getBalance());
        }
    finally{
        lock.unlock();
    }
}
}
class BankThreadTest3{
    public static void main(String[] args) {
        BankTest3 test = new BankTest3();
        Thread test1 = new Thread(test);
        Thread test2 = new Thread(test);

        test1.setName("No.1");
        test2.setName("No.2");

        test1.start();
        test2.start();
    }
}
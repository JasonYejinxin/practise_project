public class BankTest2 implements Runnable{
    private int balance;
    public int getBalance() {
        return balance;
    }
    public void addBalance(int balance) {
        this.balance += balance;
    }

    public synchronized void run() {
        addBalance(1000);
        System.out.println(Thread.currentThread().getName() + ":" + getBalance());
        addBalance(1000);
        System.out.println(Thread.currentThread().getName() + ":" +  getBalance());
        addBalance(1000);
        System.out.println(Thread.currentThread().getName() + ":" +  getBalance());
    }
}
class BankThreadTest2{
    public static void main(String[] args) {
        BankTest2 test = new BankTest2();

        Thread test1 = new Thread(test);
        Thread test2 = new Thread(test);

        test1.setName("customer1");
        test2.setName("customer2");

        test1.start();
        test2.start();
    }
}
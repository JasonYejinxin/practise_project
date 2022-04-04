class Window implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        for (; ticket > 0; ) {
            System.out.println(Thread.currentThread().getName() + ":" + ticket);
            ticket--;
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        Window test = new Window();

        Thread test1 = new Thread(test);
        Thread test2 = new Thread(test);
        Thread test3 = new Thread(test);

        test1.setName("窗口1");
        test2.setName("窗口2");
        test3.setName("窗口3");
        test1.start();
        test2.start();
        test3.start();
    }
}





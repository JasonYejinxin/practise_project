public class ThreadTest extends Thread{
    public ThreadTest(String name){
        super(name);
    }
    private static int ticket = 100;
    @Override
    public void run(){
        for(;ticket > 0;){
            System.out.println(getName() + ":" + ticket);
            ticket --;
//            try{join(100);}
//            catch(Exception e){
//                System.out.println("出错啦");
//            }
        }
    }
    public static void main(String[] args) {
        ThreadTest test1 = new ThreadTest("窗口1");

        ThreadTest test2 = new ThreadTest("窗口2");
        test1.start();
        test2.start();
    }
}

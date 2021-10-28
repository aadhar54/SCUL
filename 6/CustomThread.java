public class CustomThread implements Runnable{

    @Override
    public void run(){
        System.out.println("in thread "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        CustomThread th = new CustomThread();
        Thread thread = new Thread(th);
        //thread.run();
        thread.start();

    }
}

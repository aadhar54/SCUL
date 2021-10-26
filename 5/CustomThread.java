public class CustomThread extends Thread{


    @Override
    public void run(){
        System.out.println("we are in "+currentThread().getName());
    }

    public static void main(String[] args) {
        CustomThread th = new CustomThread();
        th.run();
    }


}
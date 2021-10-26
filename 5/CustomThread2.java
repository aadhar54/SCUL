public class CustomThread2 extends Thread{


    @Override
    public void run(){
        System.out.println("we are in "+currentThread().getName());
    }

    public static void main(String[] args) {
        CustomThread2 th = new CustomThread2();
        //th.run();

        th.start();


    }


}

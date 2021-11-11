
public class Without_Synchro {
    public static void main(String[] args) {
        Animal a1 = new Animal("Appu","elephant");
        Animal a2 = new Animal("Tuffy","dog");

        MyThread t1 = new MyThread(a1);
        MyThread t2 = new MyThread(a1);
        MyThread t3 = new MyThread(a2);
        MyThread t4 = new MyThread(a2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // All 4 threads execute simultaneously
    }
}

class MyThread extends Thread {

    Animal animal;

    public MyThread(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void run() {
        System.out.println("in thread " + currentThread().getName() +" animal : "+this.animal);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


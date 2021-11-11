
public class Object_Synchro {
    public static void main(String[] args) {
        Animal a1 = new Animal("tom","cat");
        Animal a2 = new Animal("donald","duck");

        CustomThread t1 = new CustomThread(a1);
        CustomThread t2 = new CustomThread(a1);
        CustomThread t3 = new CustomThread(a2);
        CustomThread t4 = new CustomThread(a2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class CustomThread extends Thread {

    Animal animal;

    public CustomThread(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void run() {
        synchronized (this.animal){
            //Only one Thread of Animal object a1 or a2 at one time
            // One Thread each of Animal a1 and Animal a2 can execute simultaneously
            System.out.println("in thread " + currentThread().getName() +" animal : "+ this.animal);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
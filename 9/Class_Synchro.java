
public class Class_Synchro {
    public static void main(String[] args) {
        Animal a1 = new Animal("Jamie","fox");
        Animal a2 = new Animal("Shawn","sheep");

        NewThread n1 = new NewThread(a1);
        NewThread n2 = new NewThread(a1);
        NewThread n3 = new NewThread(a2);
        NewThread n4 = new NewThread(a2);

        n1.start();
        n2.start();
        n3.start();
        n4.start();
    }
}

class NewThread extends Thread{
    Animal animal;

    public NewThread( Animal animal) {
        this.animal = animal;
    }

    @Override
    public void run() {
        synchronized (Animal.class){
            // Any thread which is operating on Animal class will be allowed
            // to execute once the previous thread has completed .
            System.out.println("in thread "+currentThread().getName()+" animal : "+this.animal+"  "+this.getName());

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

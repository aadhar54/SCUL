// Java program to demonstrate the usage of
// exception in Daemon() Thread
public class DaemonThread extends Thread
{
	public void run()
	{
		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Check if its DaemonThread: "
						+ Thread.currentThread().isDaemon());
	}

	public static void main(String[] args)
	{
		DaemonThread t1 = new DaemonThread();
		DaemonThread t2 = new DaemonThread();
		t1.start();
		
		// Exception as the thread is already started
		t1.setDaemon(true);
		
		t2.start();
	}
}


/*Runtime exception:

Exception in thread "main" java.lang.IllegalThreadStateException
    at java.lang.Thread.setDaemon(Thread.java:1352)
    at DaemonThread.main(DaemonThread.java:19)

*/
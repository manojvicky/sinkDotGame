package myJava.cts.myThreads;

public class MyThreadTest {

	public static void main(String[] args) {
//		Mythread t1 = new Mythread();
//		t1.setName("Thread 1 : ");
//		t1.start();
//		Mythread t2 = new Mythread();
//		t2.setName("Thread 2 : ");
//		t2.start();
		System.out.println("i am at top");
		UsingRunnable ur = new UsingRunnable();
		Thread t1 = new Thread(ur, "Thread 1 ");
		t1.start();
		System.out.println("i am at middle");
		Thread t2 = new Thread(ur, "Thread 2 ");
		t2.start();
		System.out.println("i am at last");
	}

}

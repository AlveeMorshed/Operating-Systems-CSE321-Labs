class MyThread1030 extends Thread{
	public MyThread1030 (String name) {
		super(name);
	}
	public void run() {
		System.out.println(getName());
		for(int i=1; i<=10; ++i) {
			System.out.print(i+" ");
		}
		System.out.println();
		MyThread20 thread2 = new MyThread20("Thread-2");
		thread2.start();
		try {
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName());
		for(int i=21; i<=30; ++i) {
			System.out.print(i+" ");
		}
	}
}
class MyThread20 extends Thread{
	public MyThread20 (String name) {
		super(name);
	}
	public void run() {
		System.out.println(getName());
		for(int i=11; i<=20; ++i) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
public class Task1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1030 thread1 = new MyThread1030("Thread-1");
		thread1.start();

	}

}

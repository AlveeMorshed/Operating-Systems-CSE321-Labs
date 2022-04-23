class MaxDivThread extends Thread{
	int from;
	int to;
	static int maxDivSoFar;
	static int theNumWithMaxDivs;
	public MaxDivThread(int start, int end) {
		from = start;
		to = end;
	}
	public void run() {
		for(int i=from; i<=to; ++i) {
			int divCount=0;
			if(i==from) {
				maxDivSoFar=0;
			}
			for(int j=1; j<=i; ++j) {
				if(i%j ==0) {
					divCount++;
				}
			}
			if(divCount>=maxDivSoFar) {
				maxDivSoFar=divCount;
				theNumWithMaxDivs=i;
			}
		}
		System.out.println(getName());
	}
}
public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxDivThread thread1 = new MaxDivThread(1,10000);
		MaxDivThread thread2 = new MaxDivThread(10001,20000);
		MaxDivThread thread3 = new MaxDivThread(20001,30000);
		MaxDivThread thread4 = new MaxDivThread(30001,40000);
		MaxDivThread thread5 = new MaxDivThread(40001,50000);
		MaxDivThread thread6 = new MaxDivThread(50001,60000);
		MaxDivThread thread7 = new MaxDivThread(60001,70000);
		MaxDivThread thread8 = new MaxDivThread(70001,80000);
		MaxDivThread thread9 = new MaxDivThread(80001,90000);
		MaxDivThread thread10 = new MaxDivThread(90001,100000);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		thread9.start();
		thread10.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
			thread6.join();
			thread7.join();
			thread8.join();
			thread9.join();
			thread10.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Answer: "+MaxDivThread.theNumWithMaxDivs+" Total Divisors="+MaxDivThread.maxDivSoFar);
	}

}

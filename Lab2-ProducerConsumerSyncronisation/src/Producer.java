import java.util.Random;

public class Producer extends Thread {
	int[] a;
	
	@Override
	public synchronized void start() {
		System.out.println("Starting Producer thread.\nValues in a:");
		
		a = new int[Lab2.n];
		
		Random ran = new Random();
		for (int i = 0; i < Lab2.n; i++){ //fill array with random numbers between 0-99 and print out
			a[i] = ran.nextInt(100);
			System.out.print(a[i] + ", ");
		}
		
		System.out.println();
		super.start();
	}

	@Override
	public void run() {
		while (Lab2.p < Lab2.n) {
			while (Lab2.p != Lab2.c);
			Lab2.buf = a[Lab2.p];
			Lab2.p = Lab2.p + 1;
		} 
		
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Producer thread has finished.\nFinal values in a:");
		for (int i = 0; i < Lab2.n; i++){
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		return;
		
	}
	
}

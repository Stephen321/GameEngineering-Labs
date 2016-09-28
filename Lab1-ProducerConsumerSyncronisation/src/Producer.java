import java.util.Random;

public class Producer extends Thread {
	int[] a;
	int n;
	int offSet;
	
	public synchronized void start(int size, int _offSet) {
		System.out.println("Starting Producer thread.\nValues in a:");
		n = size;
		offSet = _offSet;
		a = new int[n];
		
		Random ran = new Random();
		for (int i = 0; i < n; i++){ //fill array with random numbers between 0-99 and print out
			a[i] = ran.nextInt(100);
			System.out.print(a[i] + ", ");
		}
		
		System.out.println();
		super.start();
	}

	@Override
	public void run() {
		while (Lab1.p < n) {
			while (Lab1.p != Lab1.c);
			Lab1.buf = a[Lab1.p];
			Lab1.p = Lab1.p + 1;
		} 
		
		try {
			sleep(Lab1.Millis * offSet);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Producer thread has finished.\nFinal values in a:");
		for (int i = 0; i < n; i++){
			System.out.print(a[i] + ", ");
		}
		System.out.println();
		return;
		
	}
	
}

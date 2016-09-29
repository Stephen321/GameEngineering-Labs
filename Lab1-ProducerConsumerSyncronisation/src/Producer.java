import java.util.Arrays;
import java.util.Random;

public class Producer extends Thread {
	int[] a;
	
	public synchronized void start() {
		a = new int[Lab1.n];
		
		Random rand = new Random();
		for (int i = 0; i < Lab1.n; i++){ //fill array with random numbers between 0-99
			a[i] = rand.nextInt(100);
		}

		System.out.println("Starting Producer thread.\nValues in a:");
		System.out.println(Arrays.toString(a));
		super.start();
	}

	@Override
	public void run() {
		while (Lab1.p < Lab1.n) {
			while (Lab1.p != Lab1.c); //spin until p == c. This means we are ready to produce
			Lab1.buf = a[Lab1.p]; //store value from local int array into buf as its ready to be consumed
			System.out.println("Producer produced: " + Lab1.buf);
			Lab1.p = Lab1.p + 1;
		} 
		
		try {
			sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Producer thread has finished.\nFinal values in a:");
		System.out.println(Arrays.toString(a));
		return;
		
	}
	
}

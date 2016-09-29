import java.util.Arrays;

public class Consumer extends Thread {
	int[] b;
	
	public synchronized void start() {
		b = new int[Lab1.n]; //initialize new empty array

		System.out.println("Starting Consumer thread.\nValues in b:");
		System.out.println(Arrays.toString(b));
		super.start();
	}
	
	@Override
	public void run() {
		while (Lab1.c < Lab1.n) {
			while (! (Lab1.p > Lab1.c)); //spin until p > c as there is now a value to consume
			b[Lab1.c] = Lab1.buf; //consume value in buf
			System.out.println("Consumer consumed: " + Lab1.buf);
			Lab1.c = Lab1.c + 1;			
		} 
		
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Consumer thread has finished.\nFinal values in b:");
		System.out.println(Arrays.toString(b));
		return;
		
	}
	
}

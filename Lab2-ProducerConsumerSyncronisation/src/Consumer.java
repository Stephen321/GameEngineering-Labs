
public class Consumer extends Thread {
	int[] b;

	@Override
	public synchronized void start() {
		System.out.println("Starting Consumer thread.\nValues in b:");
		b = new int[Lab2.n];
		for (int i = 0; i < Lab2.n; i++){
			System.out.print(b[i] + ", ");
		}
		System.out.println();
		super.start();
	}
	
	@Override
	public void run() {
		while (Lab2.p < Lab2.n) {
			while (! (Lab2.p > Lab2.c));
			b[Lab2.c] = Lab2.buf;
			Lab2.c = Lab2.c + 1;
			
		} 
		
		try {
			sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Consumer thread has finished.\nFinal values in b:");
		for (int i = 0; i < Lab2.n; i++){
			System.out.print(b[i] + ", ");
		}
		System.out.println();
		return;
		
	}
	
}

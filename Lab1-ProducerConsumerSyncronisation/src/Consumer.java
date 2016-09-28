
public class Consumer extends Thread {
	int[] b;
	int n;
	int offSet;
	
	public synchronized void start(int size, int _offSet) {
		System.out.println("Starting Consumer thread.\nValues in b:");
		n = size;
		offSet = _offSet;
		b = new int[n];
		
		for (int i = 0; i < n; i++){
			System.out.print(b[i] + ", ");
		}
		System.out.println();
		super.start();
	}
	
	@Override
	public void run() {
		while (Lab1.p < n) {
			while (! (Lab1.p > Lab1.c));
			b[Lab1.c] = Lab1.buf;
			Lab1.c = Lab1.c + 1;
			
		} 
		
		try {
			sleep((Lab1.Millis * 2) * offSet);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Consumer thread has finished.\nFinal values in b:");
		for (int i = 0; i < n; i++){
			System.out.print(b[i] + ", ");
		}
		System.out.println();
		return;
		
	}
	
}

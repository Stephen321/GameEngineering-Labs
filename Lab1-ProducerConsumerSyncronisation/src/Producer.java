import java.util.Arrays;
import java.util.Random;

public class Producer extends Thread {
	private int id; //unique identifier for this thread
	public int[] a; //list of random ints produced
	private int counter; //counter to keep track of which int to put into the shared buffer
	private Random rand; 
	
	public void start(int id) {
		a = new int[Lab1.ArraySize]; 
		this.id = id;
		counter = 0;
		rand = new Random();
		
		//populate int array with random nums
		for (int i = 0; i < Lab1.ArraySize; i++){
			a[i] = rand.nextInt(100);
		}
		
		System.out.println("Starting Producer thread " + this.id + ".\nValues in a:");
		System.out.println(Arrays.toString(a));
		super.start();
	}

	@Override
	public void run() {
		//keep looping while we still have ints that havnt been consumed
		while(counter < Lab1.ArraySize){
            int data = a[counter]; //get data we currently want to produce
        	System.out.println("producer " + id + " produced: " + data);
            try {//put data into queue, if it is full then it will wait until there is space
            	Lab1.sharedBuffer.put(data);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        	counter++; //increment counter as this index has been shared
         }

	 	try {
	 		Thread.sleep(10 * id); //delay to try print out nicer
	 	} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished Producer thread " + this.id + ".\nFinal Values in a:");
		System.out.println(Arrays.toString(a));
	}
	
}

import java.util.Arrays;

public class Consumer extends Thread {
	private int id; //unique identifier for this thread
	public int[] b; //list of ints consumed
	private int counter; //counter to keep track of which int we are taking out of the shared buffer
	
	public void start(int id) {
		b = new int[Lab1.ArraySize];
		this.id = id;
		counter = 0;
		
		System.out.println("Starting Consumer thread " + this.id + ".\nValues in b:");
		System.out.println(Arrays.toString(b));
		super.start();
	}
	
	@Override
	public void run() {
		//keep looping while we still have space to consume ints
		while(counter < Lab1.ArraySize){
            try {//get element out of queue or wait if there is none
            	int data = Lab1.sharedBuffer.take();
            	System.out.println("consumer " + id + " consumed: " + data);
            	b[counter] = data; //put into our array 
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        	counter++;//increment counter as this index has been consumed
         }
		
	 	try {
	 		Thread.sleep(20 * id);//delay to try print out nicer
	 	} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Finished Consumer thread " + this.id + ".\nFinal Values in b:");
		System.out.println(Arrays.toString(b));
		
	}
	
}

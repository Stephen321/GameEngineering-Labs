import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class Lab1 {
	public static int ArraySize = 5; 
    public static BlockingQueue<Integer> sharedBuffer = new ArrayBlockingQueue<>(5);
	
	public static void main(String[] args) throws InterruptedException {
		//how many producers and consumers to have 
		int size = 3;
		
		//create empty arrays
		Producer[] producers = new Producer[size];
		Consumer[] consumers = new Consumer[size];

		//create all threads and start them passing in i + 1 as the id
		for (int i = 0; i < size;i++){
			producers[i] = new Producer();
			producers[i].start(i + 1);
			consumers[i] = new Consumer();
			consumers[i].start(i + 1);
		}

		//wait for all threads to end before continuing in the main thread
		for (int i = 0; i < size;i++){
			producers[i].join();
			consumers[i].join();
		}
		
		//add the sum of all the arrays to ensure we consumed all the same numbers 
		int aSum = 0;
		int bSum = 0;
		for (int i = 0; i < size;i++){
			aSum += IntStream.of(producers[i].a).sum();
			bSum += IntStream.of(consumers[i].b).sum();
		}
		
		System.out.println("Producers final sum: " + aSum + ". Consumers final sum: " + bSum + ".");
		
	}
	
}

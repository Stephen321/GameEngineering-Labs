
public class Lab1 {
	public static int buf, p = 0, c = 0;
	public static int n = 5; //size of int arrays in producer/consumer
	
	public static void main(String[] args) {
		//create threads
		Producer p1 = new Producer();
		Consumer c1 = new Consumer();
		
		//start threads
		p1.start();
		c1.start();
	}
	
}

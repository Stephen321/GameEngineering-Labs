
public class Lab1 {
	public static int buf, p = 0, c = 0;
	public static int Millis = 50; 
	
	public static void main(String[] args) {
		new Producer().start(10, 1);
		//new Producer().start(10, 2);
		new Consumer().start(20, 1);
	}
	
}


public class Lab1 {

	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();
	
	enum State {
		DeadLock,
		DeadLockSolution1,
		DeadLockSolution2
	}
	
	public static State state = State.DeadLockSolution2;
	
	public static void main(String[] args) {
		MyThread thread1 = new MyThread();
		MyThread thread2 = new MyThread();
		
		thread1.start(1);
		thread2.start(2);
	}

}

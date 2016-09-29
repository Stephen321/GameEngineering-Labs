
public class MyThread extends Thread{
	private int id; //id is used to determine which thread it is so locks can be reversed
	private int counter;
	
	public synchronized void start(int _id) {
		id = _id;
		counter = 0;
		super.start();
	}

	@Override
	public void run() {
		switch (Lab1.state){ //run the different state code
			case DeadLock:
				if (id == 1){ //lock2 is nested within lock1 for id 1 and id 2 is reversed
					synchronized (Lab1.Lock1){
				        System.out.println("Thread " + id + " is using lock 1");

			            System.out.println("Thread " + id + " is waiting on lock 2");
			            
				        synchronized (Lab1.Lock2){ //nested lock
				        	System.out.println("Thread " + id + " has locked both lock 1 and 2");      	
				        }
					}
				}
				else if (id == 2){
					synchronized (Lab1.Lock2){
				        System.out.println("Thread " + id + " is using lock 2");

			            System.out.println("Thread " + id + " is waiting on lock 1");
			            
				        synchronized (Lab1.Lock1){
				        	System.out.println("Thread " + id + " has locked both lock 1 and 2");      	
				        }
					}
				}
				break;
			case DeadLockSolution1: //maintain order of locks to eliminate deadlock
				if (id == 1){
					synchronized (Lab1.Lock1){
				        System.out.println("Thread " + id + " is using lock 1");

			            System.out.println("Thread " + id + " is waiting on lock 2");
			            
				        synchronized (Lab1.Lock2){
				               System.out.println("Thread " + id + " has locked both lock 1 and 2");      	
				        }
					}
				}
				else if (id == 2){
					synchronized (Lab1.Lock1){
				        System.out.println("Thread " + id + " is using lock 1");

			            System.out.println("Thread " + id + " is waiting on lock 2");
			            
				        synchronized (Lab1.Lock2){
				               System.out.println("Thread " + id + " has locked both lock 1 and 2");      	
				        }
					}
				}
				break;
			case DeadLockSolution2:
				if (id == 1){
					synchronized (Lab1.Lock1){
				        System.out.println("Thread " + id + " is using lock 1");

			            System.out.println("Thread " + id + " is waiting on lock 2");
					}
			        synchronized (Lab1.Lock2){
			               System.out.println("Thread " + id + " has locked both lock 1 and 2");      	
			        }
				}
				else if (id == 2){
					synchronized (Lab1.Lock2){
				        System.out.println("Thread " + id + " is using lock 2");

			            System.out.println("Thread " + id + " is waiting on lock 1");
					}
		            
			        synchronized (Lab1.Lock1){
			               System.out.println("Thread " + id + " has locked both lock 1 and 2");      	
			        }
				}
				break;
			default:
				break;				
		}
	}

}


public class MyThread extends Thread{
	int id;
	
	public synchronized void start(int _id) {
		id = _id;
		super.start();
	}

	@Override
	public void run() {
		switch (Lab1.state){
			case DeadLock:
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
					synchronized (Lab1.Lock2){
				        System.out.println("Thread " + id + " is using lock 2");

			            System.out.println("Thread " + id + " is waiting on lock 1");
			            
				        synchronized (Lab1.Lock1){
				               System.out.println("Thread " + id + " has locked both lock 1 and 2");      	
				        }
					}
				}
				break;
			case DeadLockSolution1:
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
			            
				        synchronized (Lab1.Lock2){
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
			default:
				break;				
		}
	}

}

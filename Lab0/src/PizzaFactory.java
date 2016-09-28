
public class PizzaFactory extends Thread {
	static int count = 0;
	
	@Override
	public void run() {
		int i = ++count;
		while (true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DerinaAllen.shared = i;
			
			System.out.println("Pepperoni [" + DerinaAllen.shared + "]");
		}
	}
}

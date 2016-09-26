
public class CheeseFactory extends java.lang.Object implements java.lang.Runnable {

	@Override
	public void run() {
		while (true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DerinaAllen.shared = 0;
			
			System.out.println("Making Cashel Blue [" + DerinaAllen.shared + "]");
		}
	}
}

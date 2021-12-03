import java.util.ArrayList;

/**
 * @author Zulhelmi (Zoella) Mohamad
 *
 */
public class LogisticsTester {
	Warehouse a, b, c;
	FactoryWarehouse factory;
	Truck truckA, truckB, truckC;


	public void main(String[] args) {

		ArrayList<Warehouse> dstnWarehouses;
		Thread threadTruckA, threadTruckB, threadTruckC, threadFactory;
		boolean isDebugModeOn = true;
		
		a = new Warehouse("A", false);
		b = new Warehouse("B", false);
		c = new Warehouse("C", false);
		
		dstnWarehouses = new ArrayList<Warehouse>();
		dstnWarehouses.add(a);
		dstnWarehouses.add(b);
		dstnWarehouses.add(c);

		factory = new FactoryWarehouse("Factory", dstnWarehouses, 10);
		
		truckA = new Truck(factory, a, 2);
		truckB = new Truck(factory, b, 2);
		truckC = new Truck(factory, c, 2);
		
		threadFactory = new Thread(factory);
		
		threadTruckA = new Thread(truckA);
		threadTruckB = new Thread(truckB);
		threadTruckC = new Thread(truckC);

		threadFactory.start();
		threadTruckA.start();
		threadTruckB.start();
		threadTruckC.start();

		try {
			threadFactory.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			System.out.println("Thread is shutting down");
		}
		
		while(a.getCrateCount() < 10 && b.getCrateCount() < 10 && c.getCrateCount() < 10) {
			try {
				printAllToString(isDebugModeOn);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Thread is shutting down immediately.");
			}
		}
		
		threadFactory.interrupt();
		threadTruckA.interrupt();
		threadTruckB.interrupt();
		threadTruckC.interrupt();
		
		
		if(!threadFactory.isAlive() && 
		   !threadTruckA.isAlive() && 
		   !threadTruckB.isAlive() && 
		   !threadTruckC.isAlive()) {

			printAllToString(true);
			
		}
		
		

		
	}
	
	public String printAllToString(boolean isDebugModeOn) {
		if (isDebugModeOn) {
			return factory.toString() +
				truckA.toString() + truckB.toString() + truckC.toString() + 
				a.toString() + b.toString() + c.toString();
		}
		else {
			return "";
		}

			
	}

}

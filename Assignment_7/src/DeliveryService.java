import java.util.ArrayList;

/**
 * Delivery Service main method.
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 *
 */
public class DeliveryService {
	static Warehouse a, b, c;
	static FactoryWarehouse factory;
	static Truck truckA, truckB, truckC;


	public static void main(String[] args) {
		final int TRUCK_CAPACITY = 2;
		final int CRATES_NEEDED_PER_WAREHOUSE = 10;

		ArrayList<Warehouse> dstnWarehouses;
		Thread threadTruckA, threadTruckB, threadTruckC, threadFactory;
		
		//Put false for handing in assignments, put true if you want to check how the program works per second.
		boolean isDebugModeOn = true;
		
		a = new Warehouse("A", true);
		b = new Warehouse("B", true);
		c = new Warehouse("C", true);
		
		dstnWarehouses = new ArrayList<Warehouse>();
		dstnWarehouses.add(a);
		dstnWarehouses.add(b);
		dstnWarehouses.add(c);

		factory = new FactoryWarehouse("Factory", dstnWarehouses, CRATES_NEEDED_PER_WAREHOUSE );
		
		truckA = new Truck(factory, a, TRUCK_CAPACITY);
		truckB = new Truck(factory, b, TRUCK_CAPACITY);
		truckC = new Truck(factory, c, TRUCK_CAPACITY);
		
		threadFactory = new Thread(factory);
		threadTruckA = new Thread(truckA);
		threadTruckB = new Thread(truckB);
		threadTruckC = new Thread(truckC);

		threadFactory.start();
		threadTruckA.start();
		threadTruckB.start();
		threadTruckC.start();	
		
		try {
			while(!Thread.interrupted() && 
				 (a.getCrateCount() < CRATES_NEEDED_PER_WAREHOUSE ||
				  b.getCrateCount() < CRATES_NEEDED_PER_WAREHOUSE ||
				  c.getCrateCount() < CRATES_NEEDED_PER_WAREHOUSE )) {
				System.out.print(printAllToString(isDebugModeOn));
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Debug printing is interrupted.");
		} 
		
		System.out.print(printAllToString(true));

		while(threadFactory.isAlive() ||
				threadTruckA.isAlive() ||
				threadTruckB.isAlive() ||
				threadTruckC.isAlive()) {
			threadFactory.interrupt();
			threadTruckA.interrupt();
			threadTruckB.interrupt();
			threadTruckC.interrupt();
		}
		System.out.println("All crates are delivered.");
	}
	
	/**
	 * Returns string of all the information of Factory, trucks and warehouses
	 * 
	 * @param isPrintingOk: Is it okay to print
	 * @return String : Returns a string of useful information if true,
	 * 					Returns an empty string if this is false.
	 */
	public static String printAllToString(boolean isPrintingOk) {
		if (isPrintingOk) {
			return factory.toString() + "\n" + 
				truckA.toString() + "\n" +  truckB.toString() + "\n" +  truckC.toString() + "\n" +  
				a.toString() + "\n" + b.toString() + "\n" +  c.toString() + "\n"; 
		}
		else {
			return "";
		}	
	}
}

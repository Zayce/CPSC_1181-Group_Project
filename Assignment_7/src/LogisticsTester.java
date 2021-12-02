import java.util.ArrayList;

/**
 * @author Zulhelmi (Zoella) Mohamad
 *
 */
public class LogisticsTester {;
	private Warehouse a, b, c;
	private FactoryWarehouse factory;
	private ArrayList<Warehouse> dstnWarehouses;
	private Truck truckA, truckB, truckC;
	private Thread threadTruckA, threadTruckB, threadTruckC, threadFactory;

	public static void main(String[] args) {
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
		
//		while(!Thread.interrupted()) {
//			
//			Thread.sleep(1000);
//		}

		
	}
	
	public String printAllToString() {
		return factory.toString() + a.toString() + b.toString() + c.toString() +
				truckA.toString() + truckB.toString() + truckC.toString();
	}

}

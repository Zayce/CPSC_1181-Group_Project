import java.util.ArrayList;

/**
 * FactoryWarehouse Class, warehouse that produces crates
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 *
 */
public class FactoryWarehouse extends Warehouse implements Runnable {

	private ArrayList<Warehouse> dstntnWrhs;
	private int numCrtsNeedSent;
	private int numCrtsProduced = 0;
	
	/**
	 * FactoryWarehouse Constuctor
	 * 
	 * @param nm: Name of Factory Warehouse
	 * @param dstntnWrhs: The destination warehouses in arraylist format
	 * @param numCrtsNeedSent: The amount of crates that are needed to 
	 * 		  be produced for each destination warehouse
	 */
	public FactoryWarehouse(String nm, ArrayList<Warehouse> dstntnWrhs, int numCrtsNeedSent) {
		super(nm, false);

		if(nm == null) {
			throw new NullPointerException("String is null.");
		}
		
		if(nm.equals("")) {
			throw new IllegalArgumentException("String is empty.");
		}

		
		if(dstntnWrhs == null) {
			throw new NullPointerException("Destination Warehouse is null.");
		}
		
		if(dstntnWrhs.isEmpty()) {
			throw new IllegalArgumentException("Destination Warehouse is empty.");
		}
		
		if(numCrtsNeedSent < 0) {
			throw new IllegalArgumentException("Number of Crates that need to be sent cannot be empty");
		}
		
		this.dstntnWrhs = dstntnWrhs;
		this.numCrtsNeedSent = numCrtsNeedSent;
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();	
		int maxProdPerWarehouse = 3, cratesToProduce = 0;
	
		try {
			ArrayList<String> crateProduced = new ArrayList<String>();
			while(numCrtsProduced < (numCrtsNeedSent * dstntnWrhs.size()) && !Thread.interrupted()) {
				for(Warehouse dstn: dstntnWrhs) {
					String dstnName = dstn.getName();
					
					if((this.numCrtsNeedSent - dstn.getCrateCount()) >= 3) {
						cratesToProduce = maxProdPerWarehouse;
					}
					else {
						switch(this.numCrtsNeedSent - dstn.getCrateCount()) {
						case 0:
							cratesToProduce = 0;
							break;
						case 1:
							cratesToProduce = 1;
							break;
						case 2:
							cratesToProduce = 2;
							break;
						}
					}
						
					for(int i = 0; i < cratesToProduce; i++) {
						crateProduced.add(dstnName);
						numCrtsProduced++;
					}
				}
				this.deliver(crateProduced);
				Thread.sleep(5000);		
			}
		} catch (InterruptedException e) {
			System.out.println("Factory " + threadName + " is interrupted.");
		} 
		finally {
			System.out.println("Factory finished Producing, " + threadName + " is shutting down.");
		}
	}
	
	@Override
	public String toString() {
		return super.getName() +
				" | Storing: " + super.getCrateCount() + 
				" | Produced: " + this.numCrtsProduced;
	}
}

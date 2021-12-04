import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Zulhelmi (Zoella) Mohamad
 *
 */
public class FactoryWarehouse extends Warehouse implements Runnable {

	private ArrayList<Warehouse> dstntnWrhs;
	private int numCrtsNeedSent;
	private int numCrtsProduced = 0;
	
	/**
	 * @param nm
	 * @param isWHouseCrtSmNm
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
		int limitProducePerTime = 3;
		try {
			int numCrtsNeedToBePrdcd = this.numCrtsNeedSent - this.numCrtsProduced;
			for(Warehouse dstn: dstntnWrhs) {
				ArrayList<String> dstnNames = new ArrayList<String>();
				String dstnName = dstn.getName();
				
				for(int i = 0; i < limitProducePerTime; i++) {
					dstnNames.add(dstnName);
				}
				
				do {
					numCrtsNeedToBePrdcd = this.numCrtsNeedSent - this.numCrtsProduced;
					if(numCrtsNeedToBePrdcd >= limitProducePerTime) {
						this.deliver(dstnNames);
						numCrtsProduced += limitProducePerTime;
					}
					else {
						switch(numCrtsNeedToBePrdcd) {
							case 0:
								dstnNames.removeAll(dstnNames);
								break;
							case 1:
								dstnNames.remove(dstnName);
								dstnNames.remove(dstnName);
								break;
							case 2:
								dstnNames.remove(dstnName);
								break;
						}
						this.deliver(dstnNames);
						numCrtsProduced += numCrtsNeedToBePrdcd;
					}
					Thread.sleep(5000);
				} while(numCrtsNeedToBePrdcd > 0);
			}
		} catch (InterruptedException e) {
		System.out.println("FACTWAREHOUSE " + threadName + " thread is interrupted.");
		e.printStackTrace();
		}
		finally {
			System.out.println("FACTWAREHOUSE " + threadName + " thread is shutting down immediately.");
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + super.getName() + 
				" | No. of Stored Crates: " + super.getCrateCount() + 
				" | No. of Produced Crates: " + this.numCrtsProduced;
	}
}

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
		try {
			int numCrtsNeedToBePrdcd = this.numCrtsNeedSent - this.numCrtsProduced;
			for(Warehouse dstn: dstntnWrhs) {
				if(numCrtsNeedToBePrdcd >= 3) {
					super.deliver(dstn.pickUp(dstn.getName(), 3));
				}
				else {
					super.deliver(dstn.pickUp(dstn.getName(), numCrtsNeedToBePrdcd));
				}
				numCrtsProduced++;
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
		System.out.println(threadName + " thread is interrupted.");
		e.printStackTrace();
		}
		finally {
			System.out.println(threadName + " thread is shutting down immediately.");
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + super.getName() + 
				" | No. of Stored Crates: " + super.getCrateCount() + 
				" | No. of Produced Crates: " + this.numCrtsProduced;
	}
}

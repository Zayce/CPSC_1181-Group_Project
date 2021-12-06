import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Warehouse Class
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 *
 */

public class Warehouse{

	/**
	 * 
	 */
	
	private String name;
	private ArrayList<String> curntStoredCrates;
	private boolean isWarehouseCrateSameName;
	private int errorCnt = 0;
	private Lock crateLock;
	private Condition noSameCrate;
	
	/**
	 * Warehouse Constructor
	 * 
	 * @param nm : Name of Warehouse
	 * @param isWHouseCrtSmNm: Defines if the warehouse 
	 * 		  can store crates with the same name
	 */
	public Warehouse(String nm, boolean isWHouseCrtSmNm) {
		if(nm == null || nm.equals("")) {
			throw new IllegalArgumentException("Name is null or empty.");
		}
		this.name = nm;
		this.curntStoredCrates = new ArrayList<String>(0);
		this.isWarehouseCrateSameName = isWHouseCrtSmNm;
		this.crateLock = new ReentrantLock();
		this.noSameCrate = crateLock.newCondition();
	}
	
	/**
	 * Picks up crates from current stored crates in the warehouse to be carried elsewhere.
	 * Implementation is removing Strings in current stored Crates and returning it as an
	 * arraylist with a specific maximum amount.
	 * 
	 * @param destination: The crate's destination in string format
	 * @param max: Maximum amount of crates that can be picked up/ carried.
	 * @return Arraylist of String that signifies the crate to be picked up
	 */
	public ArrayList<String> pickUp(String destination, int max){
		crateLock.lock();
		ArrayList<String> pickedUpCrates = new ArrayList<String>();
		int numOfDestCrates = 0, numCratesPickedUp;

		try {
		
			while(!this.curntStoredCrates.contains(destination)) {
				noSameCrate.await();
				Thread.sleep(500);
			}
			
			for(int i = 0; i < this.curntStoredCrates.size(); i++) {
				if(destination.equals(this.curntStoredCrates.get(i))) {
					numOfDestCrates++;
				}
			}
			
			if(numOfDestCrates >= max) {
				numCratesPickedUp = max;
			} else {
				numCratesPickedUp = numOfDestCrates;
			}
			
			while(pickedUpCrates.size() < numCratesPickedUp) {
				this.curntStoredCrates.remove(destination);
				pickedUpCrates.add(destination);		
			}
		} catch (InterruptedException e) {
			System.out.println("Pick up thread is interrupted");
		} finally {
			crateLock.unlock();
		}
		return pickedUpCrates;

	}
	
	/**
	 * Delivers the crates to the current warehouse to be stored.
	 * Implementation is removing crates in the delivery arraylist, 
	 * and adding it to the current warehouse current stored crates arraylist.
	 * 
	 * @param delivery: Arraylist of string representing crates that will be delivered to the current
	 * 					warehouse storage. After delivery is done, the delivery parameter arraylist will
	 * 					be size 0.
	 */
	public void deliver(ArrayList<String> delivery) {
		crateLock.lock();

		if(isWarehouseCrateSameName) {
			for(int i = 0; i < delivery.size(); i++) {
				if(!this.name.equals(delivery.get(i))) {
					errorCnt++;
				}
			}
		}
		
		while(delivery.size() > 0){
			this.curntStoredCrates.add(delivery.get(0));
			delivery.remove(delivery.get(0));
			noSameCrate.signalAll();
		}
		
		crateLock.unlock();
	}
	
	/**
	 * Name getter for Warehouse 
	 * 
	 * @return Name of warehouse in string format
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Crate count getter for Warehouse
	 * 
	 * @return The number of crates stored in this warehouse in integer format.
	 */
	public int getCrateCount() {
		return this.curntStoredCrates.size();
	}
	
	/**
	 * toString Method for warehouse.
	 * 
	 * @return Info about warehouse in String format including:
	 * name, no. of stored crates and errors.
	 */
	@Override
	public String toString() {
		return "Warehouse " + this.name +
				" | Storing: " + this.getCrateCount() + 
				" | Errors: " + this.errorCnt;
	}
}

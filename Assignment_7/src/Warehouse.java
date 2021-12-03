import java.util.ArrayList;

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
	
	public Warehouse(String nm, boolean isWHouseCrtSmNm) {
		this.name = nm;
		this.curntStoredCrates = new ArrayList<String>();
		this.isWarehouseCrateSameName = isWHouseCrtSmNm;
	}
	
	public ArrayList<String> pickUp(String destination, int max){
		ArrayList<String> pickedUpCrates = new ArrayList<String>();
		
		while(!this.curntStoredCrates.contains(destination)) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Thread is terminated immediately.");
			}
		}
		
		while(pickedUpCrates.size() <= max) {
				this.curntStoredCrates.remove(destination);
				pickedUpCrates.add(destination);		
		}
		
		return pickedUpCrates;
	}
	
	public void deliver(ArrayList<String> delivery) {
		for(String crates: delivery) {
			if(isWarehouseCrateSameName && !this.name.equals(crates)) {
				errorCnt++;
			}
			this.curntStoredCrates.add(crates);
			delivery.remove(crates);
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCrateCount() {
		return this.curntStoredCrates.size();
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + 
				" | No. of Stored Crates: " + this.getCrateCount() + 
				" | No. of Errors: " + this.errorCnt;
	}
}

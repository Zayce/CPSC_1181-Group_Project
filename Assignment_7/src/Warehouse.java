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
		
		try {
			while(!this.curntStoredCrates.contains(destination)) {
//				System.out.println("help.");
				Thread.sleep(500);
			}
			while(pickedUpCrates.size() < max) {
				this.curntStoredCrates.remove(destination);
				pickedUpCrates.add(destination);		
			}
		} catch (InterruptedException e) {
			System.out.println("PICK UP");
			e.printStackTrace();
		} finally {
			System.out.println("WAREHOUSE Thread is terminated immediately.");
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

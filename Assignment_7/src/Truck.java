import java.util.ArrayList;

/**
 * @author Zulhelmi (Zoella) Mohamad
 *
 */
public class Truck implements Runnable {
	
	private String name;
	private Warehouse src, dstn;
	private int maxNumCrts;
	private ArrayList<String> crtsOnTrucks;

	/**
	 * 
	 */
	public Truck(Warehouse src, Warehouse dstn, int maxNumCrts) {
		if(src == null || dstn == null) {
			throw new NullPointerException("Warehouse is null.");
		}
		
		if(maxNumCrts < 0 ) {
			throw new IllegalArgumentException("Max number of crates cannot be negative.");
		}
		
		this.src = src;
		this.dstn = dstn;
		this.maxNumCrts = maxNumCrts;
		crtsOnTrucks = new ArrayList<String>();
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			while(this.crtsOnTrucks.size() <= this.maxNumCrts) {
				src.pickUp(dstn.getName(), maxNumCrts);
			}
			try {
				Thread.sleep(1000);
				dstn.deliver(crtsOnTrucks);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Thread is interrupted.");
				e.printStackTrace();
			} finally {
				System.out.println("Thread is shutting down immediately.");
			}
		}
	}
	
	@Override
	public String toString() {
		return "Truck " + this.name + ": " + this.crtsOnTrucks;
	}

}

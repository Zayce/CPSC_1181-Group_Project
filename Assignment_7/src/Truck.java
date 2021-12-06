import java.util.ArrayList;

/**
 * Truck Class, transports crates from one place to another.
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 *
 */
public class Truck implements Runnable {
	
	private String name;
	private Warehouse src, dstn;
	private int maxNumCrts;
	private ArrayList<String> crtsOnTrucks;

/**
 * Truck Constructor
 * 
 * @param src: Source Warehouse where the truck will take the crates from.
 * @param dstn: Destination Warehouse where the truck will deliver the crates.
 * @param maxNumCrts: Maximum number of crates the truck can carry.
 */
	public Truck(Warehouse src, Warehouse dstn, int maxNumCrts) {
		if(src == null || dstn == null) {
			throw new IllegalArgumentException("Warehouse is null.");
		}
		
		if(maxNumCrts < 0 ) {
			throw new IllegalArgumentException("Max number of crates cannot be negative.");
		}
		
		this.name = "Truck " + dstn.getName();
		this.src = src;
		this.dstn = dstn;
		this.maxNumCrts = maxNumCrts;
		this.crtsOnTrucks = new ArrayList<String>();
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
	
		try {
			while(!Thread.interrupted()) {
				this.crtsOnTrucks.addAll(src.pickUp(dstn.getName(), maxNumCrts)) ;
				Thread.sleep(1000);
				dstn.deliver(crtsOnTrucks);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(this.name + " " + threadName + " thread is interrupted.");
		} finally {
			System.out.println(this.name + " of " + threadName + " thread is shutting down immediately.");
		}
	}
	
	@Override
	public String toString() {
		return this.name + ": " + this.crtsOnTrucks.toString();
	}

}

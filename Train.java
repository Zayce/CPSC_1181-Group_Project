/**
 * Train Class
 * 
 * @author Zulhelmi (Zoella) Mohamad
 *
 */

 TODO: VSCode needs Junit, JavaDocs and Java debugging to be as good as eclipse

public class Train {
	
	private String name;
	private int power;
	private int numberOfCars = 0;
	
	public Train (String n,  int p) {
		this.name = n;
		this.power = p;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String n) {
		this.name = n;
	}
	
	public String getPower() {
		return power;
	}
	public void setPower(int p) {
		this.power = p;
	}
	
	//get Arrayofcars & get&setWeight Oliver is doing.

	public int getNumberOfCars(){
		return this.numberOfCars;
	}

	//getTotalWeightOfCars Oliver is doing
	public int getTotalWeightOfCars(){
		
	}
    
	public int getMaxSpeed(int power){
		return (power - this.getTotalWeightOfCars());
	}
	

		
}

/**
 * Train Class
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 *
 */

 //TODO: VSCode needs Junit, JavaDocs and Java debugging to be as good as eclipse

public class Train {
	
	private String name;
	private int power;
	//private int weight;
	private int[] cars = null;	// Each freight car is represented by an integer representing how many tons that it
	// weighs

	// constructor
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
	
	
	// this function returns the total weights of the cars
	// @param weight scope: local variable
	// should consider null case, which is no car at all
	public int getTotalWeightOfCars(){
		int weight = 0;	
		
		if (this.cars == null){
			return weight;
		}
		
		for(int i = 0; i < this.cars.length; i++){
			weight += this.cars.length;
		}
		
		return weight;
	}


	// this fuction returns the number of cars
	// @ param scope: local variable
	// should consider null case, which is no car at all
	// if someone enter 0 for cars, weight is fine, but total number is 1, not make sence
	public int getNumberOfCars(){
		int number = 0;

		if (this.cars == null){
			return 0;
		}
		else{
			return this.cars.length;
		}
	}
    
	public int getMaxSpeed(int power){
		return (power - this.getTotalWeightOfCars());
	}
	

		
}

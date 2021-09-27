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
	private int[] cars = null;	// Each freight car is represented by an integer representing how many tons that it weighs
	private int weight = 0;
	
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
	
	public int getPower() {
		return power;
	}
	public void setPower(int p) {
		this.power = p;
	}
	
	
	/**
	 * 	Shows the total weights of the freight cars in a train in tonnes
	 * 	@returns Returns total weight of cars in a trains.
	 * 			 Returns 0 if given null or () empty arguments.
	 **/ 		
	public int getTotalWeightOfCars(){
		int weightSum = 0;	
		
		if ((this.cars == null) || cars.length <= 0){
			return weightSum;
		}
		else{		
			for(int i = 0; i < this.cars.length; i++){
			weightSum += this.cars[i];
			}
		}

		return weightSum;
	}


	// this fuction returns the number of cars
	// @ param scope: local variable
	// should consider null case, which is no car at all
	// if someone enter 0 for cars, weight is fine, but total number is 1, not make sence
	public int getNumberOfCars(){
		if ((this.cars == null) || (this.cars.length <= 0)){
			return 0;
		}
		else{
			return this.cars.length;
		}
	}
    
	public int getMaxSpeed(int power){
		return (power - this.getTotalWeightOfCars());
	}
	
	@Override
	public String toString(){
		return "";
	}

}

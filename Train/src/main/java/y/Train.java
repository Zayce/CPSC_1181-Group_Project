package y;

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
	private int[] cars = null;	// Each freight car is represented by an integer representing how many tons that it weighs
	
	public Train (String n,  int p) {
		if((n == "") || (n == null)){
			throw new IllegalArgumentException("String should not be empty or contain null.");
		}
		if(p < 0){
			throw new IllegalArgumentException("Power should not be negative.");
		}

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
		return(
		"This train " + this.getName() + "has " + this.getPower() + " amount of power.\n" + 
		"It has " + this.getNumberOfCars() + " that weighs " + this.getTotalWeightOfCars() + " tons in total");
	}

	public void removeAllCars(){
		int[] tempEmptyArray = new int[0];
		this.cars = tempEmptyArray;
	}

	public void addCars(int... weights){
		//Creating a new int array with length of both cars, and copying each value to this new array.
		int[] temp = new int[this.cars.length + weights.length];
		for(int i = 0; i < this.cars.length; i++){
			temp[i] = this.cars[i];
		}
		for(int j = this.cars.length; j < this.cars.length + weights.length; j++){
			temp[j] = weights[j-this.cars.length];
		}
		this.cars = temp;
	}
	
	public void mergeTrains(Train other){
		if ((other.cars.length <= 0) || (other != null)){
			//Adding power from other train to the current train, and setting the other train's power to zezro
			this.power += other.power;
			other.setPower(0);
			addCars(other.cars);
			removeAllCars();
		}
	}

}

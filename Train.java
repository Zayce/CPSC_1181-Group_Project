/**
 * Train Class
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 *
 **/


 public class Train {
	
	private String name;
	private int power;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
	//private int weight;
	private int[] cars = null;	// Each freight car is represented by an integer representing how many tons that it
	// weighs
=======
	private int[] cars = null;	// Each freight car is represented by an integer representing how many tons that it weighs
>>>>>>> Stashed changes

=======
	private int[] cars = new int[0];	// Each freight car is represented by an integer representing how many tons that it weighs
	
	final int MAX_SPEED = 150;
	
>>>>>>> Stashed changes
	// constructor
	private int numberOfCars = 0;
	
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
	
	
<<<<<<< Updated upstream
	// @return the total weights of the cars
	// @param weight scope: local variable
	// should consider null case, which is no car at all
=======
	/**
	 * 	Shows the total weights of the freight cars in a train in tones
	 * 	@returns Returns total weight of cars in a trains.
	 * 			 Returns 0 if given null or () empty arguments.
	 **/ 		
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
<<<<<<< Updated upstream
	// this fuction returns the number of cars
	// @ param scope: local variable
	// should consider null case, which is no car at all
	// if someone enter 0 for cars, weight is fine, but total number is 1, not make sence
=======
	// @return the number of cars
	// @param scope: local variable
	// should consider null case, which is no car at al
>>>>>>> Stashed changes
=======
	/**
	 * Shows the number of the cars in a train
	 * @return Returns the size od the array cars
	 **/
>>>>>>> Stashed changes
	public int getNumberOfCars(){
		if ((this.cars == null) || (this.cars.length <= 0)){
			return 0;
		}
		else{
			return this.cars.length;
		}
	}
<<<<<<< Updated upstream
	
    // @return the speed of the train
	// should consider null case.
	public int getMaxSpeed(int power){
		int speed = power - this.getTotalWeightOfCars();
		
		if (speed > 150) {
			speed = 150;
		}
		
		return speed;
	}
	
	// toString method that prints the summary of the train
	public String toString() {
		String result = "****Train: " + this.name + " ****";
		result += "\n Power: " + this.power;
		
		return result;
	}
	
	// remove all carss from the train
	public void removeAllCars() {
		this.cars = null;
	}
	
	// add cars
	// consider for null
	public void addCars(int... weights) {
		// new array is the concadinate of cars and weights
		int[] temp = new int[this.cars.length + weights.length - 1];
		
		// copying cars to new array
		for (int i = 0; i < this.cars.length; i++) {
			temp[i] = this.cars[i];
		}
		
		// adding new weights
		for(int i = this.cars.length; i < temp.length; i++ ) {
			temp[i] = weights[i];
		}
		
		// updating the value
		this.cars = temp;
	}
	
	public void mergeTrains(Train other) {
		power += other.power;
		addCars(other.cars);
		other.cars = [];
		other.power = 0;
		
=======
    /**
     * Shows the max speed of the train
     * @return Returns 0 if the speed is less than 0
     * 		   Retunrs 150 if the speed is higher than MAX_SPEED
     *         Returns the speed
     **/
	public int getMaxSpeed(){
		int speed = this.power - this.getTotalWeightOfCars();
		if (speed <= 0) {
			return 0;
		}
		else if(speed >= MAX_SPEED){
			return MAX_SPEED;
		}
		else {
			return speed;
		}
	}
	
	/**
	 * @return Returns the summary of the train in String format.
	 **/
	public String toString(){
		return(
		"This train " + this.getName() + " has " + this.getPower() + " amount of power.\n" + 
		"It has " + this.getNumberOfCars() + " that weighs " + this.getTotalWeightOfCars() + " tons in total.");
>>>>>>> Stashed changes
	}

	public void removeAllCars(){
		int[] tempEmptyArray = new int[0];
		this.cars = tempEmptyArray;
	}
	
	/**
	 * Concatenate two valid array
	 * @param weights is the array to be added
	 * @return Returns the updated cars array
	 **/
	public void addCars(int... weights){
		if((weights == null) || (weights.length <= 0)){
			throw new IllegalArgumentException("Weight input should not be empty or contain null.");
		}
		
		for(int i = 0; i < weights.length; i++) {
			if(weights[i] < 0) {
				throw new IllegalArgumentException("Weights cannot be negative.");
			}
		}
		
		if(this.cars == null || this.cars.length <= 0) {
			int[] temp = new int[weights.length];
			this.cars = temp;		
			System.arraycopy(weights, 0, this.cars, 0, weights.length);
		}
		else {
			int[] temp = new int[this.cars.length + weights.length];
			for (int i = 0; i < this.cars.length; i++) {
				temp[i] = this.cars[i];
			}
			for (int i = this.cars.length; i < temp.length; i++) {
				temp[i] = weights[i-this.cars.length];
			}
			this.cars = temp;
			//System.arraycopy(weights, 0, this.cars, this.cars.length - weights.length, weights.length);
		}


	}
	/**
	 * Merge one train to another
	 * @param other is the train to merged
	 * @return Returns the train after merged with other
	 **/
	public void mergeTrains(Train other){
		if ((other.cars.length <= 0) || (other != null)){
			//Adding power from other train to the current train, and setting the other train's power to zezro
			this.power += other.power;
			other.setPower(0);
			this.addCars(other.cars);
			other.removeAllCars();
		}
	}

}
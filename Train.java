/**
 * Train Class
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 *
 **/


 public class Train {
	
	/**
	 * some variables for the class
	 * **/
	private String name;
	private int power;
	private int[] cars = new int[0];
	final int MAX_SPEED = 150;		// instead of magic number 150
	
	/**
	 * constructor
	 * **/
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
	/**
	 * @return the name of the train
	 **/	
	public String getName() {
		return name;
	}
	
	/**
	 * set the name for train object, cannot be null or empty  string
	 **/
	public void setName(String n) {
		if (n == "" || n == null) {
			throw new IllegalArgumentException("Invalid name");
		}
		else {
			this.name = n;
		}
	}
	
	/**
	 * @return the power of the train
	 **/
	public int getPower() {
		return power;
	}
	
	/**
	 * set the power for train object, cannot be negative
	 **/
	public void setPower(int p) {
		if (p < 0) {
			throw new IllegalArgumentException("Power must not be negative");
		}
		else {
			this.power = p;
		}
	}
	
	
	/**
	 * 	Shows the total weights of the freight cars in a train in tones
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

	/**
	 * Shows the number of the cars in a train
	 * @return Returns the size od the array cars
	 **/
	public int getNumberOfCars(){
		if ((this.cars == null) || (this.cars.length <= 0)){
			return 0;
		}
		else{
			return this.cars.length;
		}
	}
    /**
     * Shows the max speed of the train
     * @return Returns the speed
     * 		   Retunrs 150 if the speed is higher than MAX_SPEED
     *         Returns 0 if the speed is less than 0
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
	}

	/**
	 * remove all the cars and set to empty array for the train object
	 * **/
	public void removeAllCars(){
		int[] tempEmptyArray = new int[0];
		this.cars = tempEmptyArray;
	}
	
	/**
	 * Concatenate two valid array
	 * @param weights is the array to be added, cannot be null
	 * @return Returns the updated cars array
	 **/
	public void addCars(int... weights){
		// exclude null for weights
		if((weights == null) || (weights.length <= 0)){
			throw new IllegalArgumentException("Weight input should not be empty or contain null.");
		}
		
		// exclude negative inputs
		for(int i = 0; i < weights.length; i++) {
			if(weights[i] < 0) {
				throw new IllegalArgumentException("Weights cannot be negative.");
			}
		}
		
		// [] and null for cars array
		if(this.cars == null || this.cars.length <= 0) {
			this.cars = weights;		
		}
		else {
			// new array that has the combining length
			int[] temp = new int[this.cars.length + weights.length];
			
			// copying cars to temp
			for (int i = 0; i < this.cars.length; i++) {
				temp[i] = this.cars[i];
			}
			
			// copying weights to temp
			for (int i = this.cars.length; i < temp.length; i++) {
				temp[i] = weights[i-this.cars.length];
			}
			
			// update cars
			this.cars = temp;
		}
	}
	
	/**
	 * Merge one train to another
	 * @param other is the train to merged
	 * @return Returns the train after merged with other
	 **/
	public void mergeTrains(Train other){
		if ((other.cars.length <= 0) || (other != null)){
			//Adding power from other train to the current train, and setting the other train's power to zezo
			this.power += other.power;
			other.setPower(0);
			this.addCars(other.cars);
			other.removeAllCars();
		}
	}
}
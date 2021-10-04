/**
 * Train Class
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 *
 */

public class Train {
	
	private String name;
	private int power;
	private int[] cars = new int[0];
	
	final int MAX_SPEED = 150;
	
	/**
	 * Constructor for train class
	 * @param: n = name of the train
	 * 		   p = power of the train
	 * @return: no return value, only intializes the train class. 
	 * 			Throws an error if name is empty or null. Throws another error if power is negative. 
	 */
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
	 * Getter for name.
	 * @return: name of the train in string format.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for name
	 * @param: n = name of the train.
	 * @return: void. Throws an exception if string is null or empty.
	 */
	public void setName(String n) {
		if (n == null || n.equals("")) {
			throw new IllegalArgumentException("Name should not be null or empty.");
		}
		else{
			this.name = n;
		}
	}
	
	/**
	 * Getter for power
	 * @return: Power of the train in integer.
	 */
	public int getPower() {
		return power;
	}
	
	/**
	 * Setter for name
	 * @param: p = power of the train.
	 * @return: void. Throws an exception if power given is negative
	 */
	public void setPower(int p) {
		if (p < 0) {
			throw new IllegalArgumentException("Power can't be negative.");
		}
		else{
			this.power = p;
		}
	}
	
	/**
	 * 	Shows the total weights of the freight cars in a train in tonnes
	 * 	@returns Returns total weight of cars in a trains.
	 * 			 Returns 0 if given null or empty arguments.
	 */ 		
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
	 * Getter for number of cars
	 * @return: The number of cars in intgers. 
	 * 			Returns 0 if this.cars is null or it has length zero or less.
	 */
	public int getNumberOfCars(){
		if ((this.cars == null) || (this.cars.length <= 0)){
			return 0;
		}
		else{
			return this.cars.length;
		}
	}
    
	/**
	 * Calculates the maximum speed in km/h from ths total weight of cars with some restrictions.
	 * @param: speed = integer that calculates the maximum speed allowed by 
	 * 				   finding the difference between power and total weight.
	 * @return: Returns zero if the speed is less than zero.
	 * 			Returns MAX_SPEED = 150 if the speed is greater than 150.
	 * 			Returns the speed if it is more than zero and less than 150.
	 */
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
	 * Summarizes the contents of train and outputs it to a string.
	 * @return: returns a string that summarizes the attribues of the Train object.
	 */
	@Override
	public String toString(){
		return(
		"This train " + this.getName() + " has " + this.getPower() + " amount of power.\n" + 
		"It has " + this.getNumberOfCars() + " cars that weighs " + this.getTotalWeightOfCars() + " tons in total.");
	}

	/**
	 * Removes all cars from a train object.
	 * @return: void.
	 **/
	public void removeAllCars(){
		int[] tempEmptyArray = new int[0];
		this.cars = tempEmptyArray;
	}

	/**
	 * Adds weights of cars in variable length 
	 * @param weights: variable length array of integers that indicates the weights of each car.
	 * @return Throws an illegal argument exception if weights array is null or has length of zero or less.
	 * 		   Throws an illegal argument exception if any of the values in the weights array is negative.
	 */
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
			this.cars = weights;
		}
		else {
			int[] temp = new int[this.cars.length + weights.length];
			System.arraycopy(this.cars, 0, temp, 0, this.cars.length);
			this.cars = temp;
			System.arraycopy(weights, 0, this.cars, this.cars.length - weights.length, weights.length);
		}
	}
	
	/**
	 * Merges two trains, by transferring all power and cars of the other train to this train.
	 * @param other = Train object that will transfer power and cars to this train.
	 * @return void.
	 */
	public void mergeTrains(Train other){
		this.setPower(this.power + other.power);
		other.setPower(0);
		this.addCars(other.cars);
		other.removeAllCars();
	}
}
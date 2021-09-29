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
	private int[] cars = new int[0];	// Each freight car is represented by an integer representing how many tons that it weighs
	
	final int MAX_SPEED = 150;
	
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
		if (n == null || n.equals("")) {
			throw new IllegalArgumentException("Name should not be null or empty.");
		}
		else{
			this.name = n;
		}
	}
	
	public int getPower() {
		return power;
	}
	
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

	public int getNumberOfCars(){
		if ((this.cars == null) || (this.cars.length <= 0)){
			return 0;
		}
		else{
			return this.cars.length;
		}
	}
    
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
	
	@Override
	public String toString(){
		return(
		"This train " + this.getName() + " has " + this.getPower() + " amount of power.\n" + 
		"It has " + this.getNumberOfCars() + " cars that weighs " + this.getTotalWeightOfCars() + " tons in total.");
	}

	public void removeAllCars(){
		int[] tempEmptyArray = new int[0];
		this.cars = tempEmptyArray;
	}

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
	
	public void mergeTrains(Train other){
		if ((other.cars.length <= 0) || (other != null)){
			//Adding power from other train to the current train, and setting the other train's power to zezro
			this.setPower(this.power + other.power);
			other.setPower(0);
			this.addCars(other.cars);
			other.removeAllCars();
		}
	}
}
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
<<<<<<< Updated upstream
	//private int weight;
	private int[] cars = null;	// Each freight car is represented by an integer representing how many tons that it
	// weighs
=======
	private int[] cars = null;	// Each freight car is represented by an integer representing how many tons that it weighs
>>>>>>> Stashed changes

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
	
	
	// @return the total weights of the cars
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
	public int getNumberOfCars(){
		int number = 0;

		if (this.cars == null){
			return 0;
		}
		else{
			return this.cars.length;
		}
	}
	
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
		
	}

		
}

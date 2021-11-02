/** 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 **/

public abstract class ConsoleShape implements Comparable<ConsoleShape>, ConsoleDrawable{
	private boolean isFilledIn;

	/**
	 * Constructor with input
	 * @param	fI: If shape is filled
	 */
	public ConsoleShape(boolean fI){
		this.isFilledIn = fI;
	}
	
	/**
	 * Default no name constructor
	 */
	public ConsoleShape(){
		this(false);
	}

	/**
	 * @return The boolean value whether a shape is filled in
	 */
	public boolean isFilledIn(){
		return this.isFilledIn;
	}
	
	/**
	 * Sets the shape's property to be filled or not
	 * 
	 * @param fI: filledIn boolean value
	 */
	public void setFilledIn(boolean fI){
		this.isFilledIn = fI;
	}

	/**
	 * @return string that describes the status of the rectangle
	 */
	@Override
	public String toString(){
		return "Shape attributes | Filled In: " + this.isFilledIn + " | Area: " + this.getArea() + " | Perimeter: " + this.getPerimeter(); 
	}

	public abstract double getArea();
	public abstract int getPerimeter();
	public abstract String drawForConsole();
	
	/**
	 * @param other: Other ConsoleShape object
	 * @return 	If other shape is null, throws an Null pointer exception
	 * 			Returns 1 if the current shape's area is greater than the other shape
	 * 			Returns 0 if they're both equal
	 * 			Returns -1 if the current shape's area is smaller than the other shape
	 **/
	
	public int compareTo(ConsoleShape other) {
		if(other == null) {
			throw new NullPointerException("Other is null"); 
		}
		
		//Tolerance for double value is epsilon
		final double EPSILON = 0.000001;
		double difference = this.getArea() - other.getArea();
	

		if((difference > EPSILON)) {
			return 1;
		}
		else if(Math.abs(difference) <= EPSILON) {
			return 0;
		}
		else {
			return -1;
		}
				 
	}

}
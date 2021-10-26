/** 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 * 
 **/

public abstract class ConsoleShape implements Comparable<ConsoleShape>, ConsoleDrawable{
	private boolean isFilledIn;

	/**
	 * Constructor with input
	 * @param l: length of shape
	  	  w: width of shape
		  c: colour of shape
		  f: If shape is filled
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
	 * @return boolean express of the rectangle is filled in or not
	 * **/
	public boolean isFilledIn(){
		return this.isFilledIn;
	}
	
	/**
	 * @param fI: a boolean express of the rectangle is filled in or not
	 * **/
	public void setFilledIn(boolean fI){
		this.isFilledIn = fI;
	}

	/**
	 * @return string that describes the status of the rectangle
	 * **/
	@Override
	public String toString(){
		return "Shape attributes | Filled In: " + this.isFilledIn + " | Area: " + this.getArea() + " | Perimeter: " + this.getPerimeter(); 
	}

	public abstract double getArea();
	public abstract int getPerimeter();
	public abstract String drawForConsole();
	
	/**
	 * @param other: other rectangle with the class of ConsoleShape
	 * @return if other rectangle is null, return string with information
	 *         if this rectangle's area is greater, return true
	 *         if other rectangle's area is greater or equal, return false
	 *         if situation other than greater lesser or equal occurs, return -1
	 * **/
	public int compareTo(ConsoleShape other) {
		if(other == null) {
			throw new NullPointerException("Other is null"); 
		}
		
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
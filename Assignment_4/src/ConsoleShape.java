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

	public boolean isFilledIn(){
		return this.isFilledIn;
	}
	
	public void setFilledIn(boolean fI){
		this.isFilledIn = fI;
	}

	
	@Override
	public String toString(){
		return "Shape attributes | Filled In: " + this.isFilledIn + " | Area: " + this.getArea() + " | Perimeter: " + this.getPerimeter(); 
	}

	public abstract double getArea();
	public abstract int getPerimeter();
	public abstract String drawForConsole();
	
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
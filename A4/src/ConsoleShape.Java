//Author comments to be added

public abstract class ConsoleShape{
	private int length;
	private int width;
	private String colour;
	private boolean filledIn;

	/**
	 * Constructor with input
	 * @param l: length of shape
	  	  w: width of shape
		  c: colour of shape
		  f: If shape is filled
	 */
	public ConsoleShape(int l, int w, String c, boolean fI){
		this.length = l;
		this.width = w;
		this.colour = c;
		this.filledIn = fI;
	}
	
	/**
	 * default no name constructor
	 */
	public ConsoleShape(){
		this(1, 1, "White", false);
	}

	public int getLength(){
		return this.length;
	}
	
	public void setLength(int l){
		this.length = l;
	}

	public int getWidth(){
		return this.length;
	}
	
	public void setWidth(int w){
		this.width = w;
	}

	public int getColour(){
		return this.colour;
	}
	
	public void setColour(String c){
		this.colour = c;
	}


	public boolean getFilledIn(){
		return this.FilledIn;
	}
	
	public void setFilledIn(boolean fI){
		this.filledIn = fI;
	}

	
	@Override
	public String toString(){
		return "Shape attributes [Length: " + this.length + " | Width: " + this.width + " | Area: " + this.getArea() + " | Perimeter: " + this.getPerimeter() + " | Colour: " + this.colour " | Filled In: " + this.FilledIn;
	}

	public abstract int getArea();
	public abstract int getPerimeter();
	

}
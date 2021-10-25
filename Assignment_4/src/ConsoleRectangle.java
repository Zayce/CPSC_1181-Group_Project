/** 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 * 
 * Rectangle in console object
 **/

public class ConsoleRectangle extends ConsoleShape {
	
	private int width;
	private int height;

	/**
	 * @param 	fI: Boolean data that tells is rectangle is filled in
	 * 			w: Width of rectangle
	 * 			h: Height of rectangle
	 */
	public ConsoleRectangle(boolean fI, int w, int h) {
		super(fI);

		//TODO: In final version, we will discuss and choose which case to go for after consulting the Prof
		if(w <= 0 || h <= 0) {
			//Case: Converting negative ints to positive
			w = Math.abs(w);
			h = Math.abs(h);
			//Case: Throwing Argument
			throw new IllegalArgumentException("Height and weight needs to be a postitive integer.");
		}
		
		this.width = w;
		this.height = h;
	}

	/**
	 * Default constructor setting rectangle object to not be filled in, with height and width of 1 unit long
	 */
	public ConsoleRectangle() {
		this(false, 1, 1);
	}
	
	/**
	 * Width of a rectangle in unit of 1 character
	 * 
	 * @return width in integer form
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Sets the wdith of the rectangle
	 * 
	 * @param w: Width of the rectangle
	 */
	public void setWidth(int w) {
		this.width = w;
	}
	
	/**
	 * Height of a rectangle in unit of 1 character
	 * 
	 * @return Height in integer form
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Sets the height of the rectangle
	 * 
	 * @param h: Height of the rectangle
	 */
	public void set(int h) {
		this.height = h;
	}

	/**
	 * Calculates area of a rectangle
	 */
	@Override
	public double getArea() {
		return this.width * this.height;
	}

	/**
	 * Calculates perimeter of a rectangle
	 */
	@Override
	public int getPerimeter() {
		return 2*(this.width + this.height);
	}
	
	/**
	 * Overridden toString Method for ConsoleRectangle
	 */
	@Override
	public String toString() {
		return super.toString() + " | Width: " + this.width +  " | Height: " + this.height;
	}

}

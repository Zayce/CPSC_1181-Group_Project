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
	public ConsoleRectangle(boolean fI, int h, int w) {
		super(fI);

		//TODO: In final version, we will discuss and choose which case to go for after consulting the Prof
		if( h <= 0 || w <= 0 ) {
			//Case: Converting negative ints to positive
			h = Math.abs(h);
			w = Math.abs(w);
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
	public void setHeight(int h) {
		this.height = h;
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
	 * Draws a rectangle and shows it to the console
	 * 
	 * @return String that contains "#", " " and "\n" to draw a rectangle of any size and if it is filled.
	 */
	public String drawForConsole() {
		String consoleDrawn = "";
		boolean isBorder;
		for(int r = 0; r < height; r++) {
			for(int c = 0; c < width; c++) {
				isBorder = ((r == 0 || r == height-1) || (c == 0 || c == width - 1));
				//We only enter a space character when the row an column is not a filled in shape and it's not on the borders, then # for anything else.
				if(isBorder || super.isFilledIn()) {
					consoleDrawn += "#";
				}
				else {
					consoleDrawn += " ";
				}
				consoleDrawn += "\n";
			}
		}
		
		return consoleDrawn;	
	}
	
	/**
	 * Overridden toString Method for ConsoleRectangle
	 */
	@Override
	public String toString() {
		return super.toString() + " | Width: " + this.width +  " | Height: " + this.height;
	}

}

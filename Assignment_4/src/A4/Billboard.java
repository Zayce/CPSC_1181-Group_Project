/**
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 */

public class Billboard implements ConsoleDrawable {
	
	private String message;
	
	/**
	 * constructor with string message
	 * @param msg: the message on the billboard
	 **/
	public Billboard(String msg) {
		this.message = msg;
	}
	
	/**
	 * default no name constructor
	 * set the message to empty string
	 **/
	public Billboard() {
		this.message = "";
	}
	
	/**
	 * @return the message of the billboard
	 **/
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * @param msg: the message of the billboard
	 **/
	public void setMessage(String msg) {
		this.message = msg;
	}
	
	/**
	 * Billboard's drawForConsole is essentially a message surrounded one space and # to it.
	 * So it should draw a unfilled rectangle of height 5 and width of the messages's length + 4 to account
	 * for one spaces and one # on each side.
	 * The billboard's message would be right in the middle.
	 * 
	 * @return the billboard in string data type
	 **/
	@Override
	public String drawForConsole() {
		int height = 5;
		int width = this.message.length() + 4;
		boolean isBorder;
		String consoleDrawn = "";
		
		for(int r = 0; r < height; r++) {
			for(int c = 0; c < width; c++) {
				isBorder = ((r == 0 || r == height-1) || (c == 0 || c == width - 1));

				if(isBorder) { //If the element is in the border, then we would add "#"
					consoleDrawn += "#";
				}
				else if(r == 2 && c == 2) { //Where the message starts
					consoleDrawn += (this.message + " ") ;
				}
				else if(r == 2 && c > 2) { // To add nothing so no extra unfilled spaces are added
					consoleDrawn += "";
				}
				else {// Adds an empty space for everything els
					consoleDrawn += " ";
				}
			}
			consoleDrawn += "\n";
		}
		return consoleDrawn;
	}

}

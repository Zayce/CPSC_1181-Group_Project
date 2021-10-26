/**
 * 
 */

/**
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu 
 *
 */
public class Billboard implements ConsoleDrawable {

	/**
	 * 
	 */
	
	private String message;
	
	/**
	 * constructor with string message
	 * @param msg: the message on the billboard
	 * **/
	public Billboard(String msg) {
		this.message = msg;
	}
	
	/**
	 * default no name constructor
	 * set the message to empty string
	 * **/
	public Billboard() {
		this.message = "";
	}
	
	/**
	 * @return the message of the billboard
	 * **/
	public String getMessage() {
		return this.message;
	}
	
	/**
	 * @param msg: the message of the billboard
	 * **/
	public void setMessage(String msg) {
		this.message = msg;
	}
	
	/**
	 * @return the billboard
	 * **/
	@Override
	public String drawForConsole() {
		int height = 5;
		int width = this.message.length() + 4;
		boolean isBorder;
		String consoleDrawn = "";
		
		for(int r = 0; r < height; r++) {
			for(int c = 0; c < width; c++) {
				isBorder = ((r == 0 || r == height-1) || (c == 0 || c == width - 1));

				if(isBorder) {
					consoleDrawn += "#";
				}
				else if(r == 2 && c == 2) {
					consoleDrawn += (this.message + " ") ;
				}
				else if(r == 2 && c > 2) {
					consoleDrawn += "";
				}
				else {
					consoleDrawn += " ";
				}
			}
			consoleDrawn += "\n";
		}
		return consoleDrawn;
	}

}

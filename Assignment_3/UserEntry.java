/**
 * @author Chendong (Oliver) Zhu
 * @author Zulhelmi (Zoella) Mohamad
 */


import java.util.Scanner;

public abstract class UserEntry {
	public final Scanner input;
	public final String prompt;
	
	// constructor
	public UserEntry(Scanner input, String prompt) {
		this.input = input;
		this.prompt = prompt;
	}
	
	// subclasses will implement to get user input in their own way
	public abstract String getUserResponse();
}

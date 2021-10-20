/**
 * @author Chendong (Oliver) Zhu
 * @author Zulhelmi (Zoella) Mohamad
 */

import java.util.ArrayList;
import java.util.Scanner;


public class UserMenuEntry extends UserEntry {
	private ArrayList<String> options =  new ArrayList<String>();
	
	final static String PROMPT = "Enter a number from the choices above: ";
	
	public UserMenuEntry(Scanner userInput, ArrayList<String> options) {
		super(userInput, PROMPT);
		this.options = options;
	}
	
	@Override
	public String getUserResponse() {
		int userInput;
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i + ": " + this.options.get(i));
		}
		
		boolean isValidInput = false;
		do{
			System.out.print(this.prompt);
			userInput = super.input.nextInt();
			if( 0 <= userInput && userInput <= this.options.size() - 1) {
				isValidInput = true;
				System.out.println("User chose: " +  this.options.get(userInput) + "\n");
			}
		} while (isValidInput == false);
		
		
		return String.valueOf(userInput); //this.options.get(userInput)
	}
}

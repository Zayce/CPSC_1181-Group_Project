/**
 * @author Chendong (Oliver) Zhu
 * @author Zulhelmi (Zoella) Mohamad
 */

import java.util.Scanner;

public class MultiLineEntry extends UserEntry{
	public MultiLineEntry(Scanner input, String prompt) {
		super(input, prompt);
	}

	@Override
	public String getUserResponse() {
		String response = "";
		
		// Displays the user prompt
		System.out.println(prompt);
		
		// take the input
		String thisLine = input.nextLine();
		while (thisLine != "") {
			response +=  "\n" + thisLine;
			thisLine = input.nextLine();
		}
		
		return response;
	}
	

}

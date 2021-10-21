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
		String thisLine;
		
		// Displays the user prompt
		System.out.print(prompt);
		
		// take the input
		do {
			thisLine = input.nextLine();
			response +=  thisLine +"\n";
		} while (!thisLine.equals(""));
		
		return response;
	}
	

}

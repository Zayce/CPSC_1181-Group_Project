import java.util.Scanner;

public class MultiLineEntry extends UserEntry{
	public MultiLineEntry(Scanner input, String prompt) {
		super(input, prompt);
	}

	@Override
	public String getUserResponse() {
		String response = "";
		
		// display the user prompt
		System.out.println("The user select: " + prompt);
		
		// take the input
		String thisLine = input.nextLine();
		while (thisLine != "") {
			response +=  "\n" + thisLine;
			thisLine = input.nextLine();
		}
		
		return response;
	}
	

}

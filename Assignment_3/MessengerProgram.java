/**
 * 
 */

/**
 * @author Chendong (Oliver) Zhu
 * @author Zulhelmi (Zoella) Mohamad
 *
 */

import java.util.Scanner;
import java.util.ArrayList;

public class MessengerProgram {
		private Scanner sc;
		private Messenger msngr;
		private UserMenuEntry selectUser;
		private UserMenuEntry mainMenu;
		private MultiLineEntry mle;
		private String activeUser;
	
	public static void main(String[] args) {
		MessengerProgram prog = new MessengerProgram();
		prog.execute();
	}
	
	public MessengerProgram() {
		this.sc = new Scanner(System.in);
		this.msngr = new Messenger();		
		initUserMsg();
		this.selectUser = new UserMenuEntry(sc, msngr.getUserList());
		this.mainMenu = new UserMenuEntry(sc, this.initMainMenuOptions());
		this.mle = new MultiLineEntry(sc, "Type your message: \n");

	}
	
	public void execute() {
		String userChoiceStr;
		int userChoiceInt;

		this.getActiveUser();
		
		userChoiceStr = mainMenu.getUserResponse();
		userChoiceInt = Integer.parseInt(userChoiceStr);
		
		switch(userChoiceInt) {
			case 0:
				//See all messages
				System.out.println(this.msngr.getReceivedMessages(this.activeUser));
				break;
			case 1:
				//See unread messages
				this.msngr.getReceivedMessages(this.activeUser, Message.StatusType.UNREAD);
				break;
			case 2:
				//Send message, must use mle
				this.mle.getUserResponse();
				break;
			case 3:
				//send smile
				this.msngr.sendSmile(this.activeUser, userChoiceStr);
				break;
			case 4:
				//Change active user
				this.getActiveUser();
				break;
			case 5:
				//see Messenger stats so must indicate all info
				
				break;
			case 6:
				System.exit(0);
				break;
			default:
				throw new IllegalArgumentException("Illegal argument.");
		}
		
	}
	
	public void initUserMsg() {
		this.msngr.addUser("Zoey");
		this.msngr.addUser("Oliver");
		this.msngr.addUser("Amelia");
		this.msngr.sendMessage("Zoey", "Amelia", "Hi there");
		this.msngr.sendMessage("Amelia", "Zoey", "Howdy Partner");
	}
	
	public void getActiveUser() {
		System.out.println("Choose Active User");
		this.activeUser = this.selectUser.getUserResponse();
	}
	
	public ArrayList<String> initMainMenuOptions(){
		ArrayList<String> mainMenu = new ArrayList<String>();
		
		mainMenu.add("See All Messages");
		mainMenu.add("See Unread Messages");
		mainMenu.add("Send Message");
		mainMenu.add("Send Smile");
		mainMenu.add("Switch Active User");
		mainMenu.add("See Messenger Stats");
		mainMenu.add("Exit");
		
		return mainMenu;
	}


}

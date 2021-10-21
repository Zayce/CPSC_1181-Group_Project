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
		private ArrayList<String> mainMenuOptions;
		private MultiLineEntry mle;
		private String activeUser;
	
	public static void main(String[] args) {
		MessengerProgram prog = new MessengerProgram();
		prog.execute();
	}
	
	public MessengerProgram() {
		this.sc = new Scanner(System.in);
		this.msngr = new Messenger();		
		this.initUserMsg();
		this.selectUser = new UserMenuEntry(sc, msngr.getUserList());
		this.mainMenuOptions = new ArrayList<String>();
		this.initMainMenuOptions();
		this.mainMenu = new UserMenuEntry(sc, this.mainMenuOptions);
		this.mle = new MultiLineEntry(sc, "Type your message: ");
	}
	
	public void execute() {
		String userChoiceStr;

		this.getActiveUser();
		
		do {
			userChoiceStr = mainMenu.getUserResponse();
			switch(userChoiceStr) {
				case "See All Messages":					
					printMessages(this.msngr.getReceivedMessages(this.activeUser));
					break;
				case "See Unread Messages":
					//TODO: need to fix below to only show unread messages
					printMessages(this.msngr.getReceivedMessages(this.activeUser, Message.StatusType.UNREAD));
					break;
				case "Send Message":
					this.msngr.sendMessage(this.activeUser, this.getSender(), this.mle.getUserResponse());
					break;
				case "Send Smile":
					this.msngr.sendSmile(this.activeUser, this.getSender());
					break;
				case "Switch Active User":
					this.getActiveUser();
					break;
				case "See Messenger Stats":
					this.msgSummary();
					break;
				case "Exit":
					System.out.println("Program Closed");
					System.exit(0);
				default:
					throw new IllegalArgumentException("Illegal argument.");
			}
		} while(!userChoiceStr.equals("Exit"));
		
	}
	
	public void initUserMsg() {
		this.msngr.addUser("Zoey");
		this.msngr.addUser("Oliver");
		this.msngr.addUser("Amelia");
		this.msngr.sendMessage("Zoey", "Amelia", "Hi there");
		this.msngr.sendMessage("Amelia", "Zoey", "Howdy Partner");
		this.msngr.sendMessage("Oliver", "Zoey", "Did you finish the assignment yet?");
	}
	
	public void getActiveUser() {
		System.out.println("Choose Active User");
		this.activeUser = this.selectUser.getUserResponse();
	}
	
	public String getSender() {
		System.out.println("Choose who to send this to: ");
		return this.selectUser.getUserResponse();
	}
	
	public void msgSummary() {
		Message m = this.msngr.getReceivedMessages(this.activeUser).get(0);
		System.out.println("Message Count: " + m.getMessageCount());
		System.out.println("Text Length: " + m.getTextLength());
		System.out.println("\n");
	}
	
	public void initMainMenuOptions(){		 
		this.mainMenuOptions.add("See All Messages");
		this.mainMenuOptions.add("See Unread Messages");
		this.mainMenuOptions.add("Send Message");
		this.mainMenuOptions.add("Send Smile");
		this.mainMenuOptions.add("Switch Active User");
		this.mainMenuOptions.add("See Messenger Stats");
		this.mainMenuOptions.add("Exit");
	}
	
	void printMessages(ArrayList<Message> msgList) {
		MultiLineEntry enterNext = new MultiLineEntry(this.sc, "Press Enter To Continue");
		if (msgList == null) {
			System.out.println("[No messages available]");
		}
		else {
			for(Message m: msgList) {
				System.out.println(m.toString() + "\n");
				enterNext.getUserResponse();
			}
		}
	}


}

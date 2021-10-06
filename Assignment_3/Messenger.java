/**
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 * 
 * 
 */

import java.util.ArrayList;

public class Messenger {

	private ArrayList<String> userNames =  new ArrayList<String>();
	private ArrayList<Message> messagesList =  new ArrayList<Message>();
	
	/**
	 * Adds a username into the userNames arraylist. Adds nothing if the username is already in the arraylist and returns voids.
	 *
	 * @param username is a unique name or ID
	 * @return void and does nothing if username already exist in userNames arraylists.
	 */
	void addUser(String username) {
		if(userNames.contains(username)) {
			return void;
		}else {
			userNames.add(username);
		}
	}
	
	/**
	 * Sends a message that contains text from sender to receiver. 
	 * 
	 * @param sender:   Sender username
	 * 		  receiver: Receiver username
	 * 		  text:     Text to be sent from sender to receiver
	 * @return void, throws exception if either sender or receiver is not in the useNames arraylist.
	 */
	void sendMessage(String sender, String receiver, String text) {
		if(userNames.contains(sender) || userNames.contains(sender)) {
			Message msg = new Message(text, sender, receiver, StatusType.UNREAD);
		}
		else {
			throw new IllegalArgumentException("Either sender or receiver doesn't exist.");
		}
	}
	
	ArrayList<Message> getReceivedMessages(String receiver){
		
	}
	
	ArrayList<Message> getReceivedMessages(String receiver, StatusType s){
		
	}
	
	
}

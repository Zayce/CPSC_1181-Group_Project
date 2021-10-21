/**
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 * 
 * 
 */

import java.util.ArrayList;

public class Messenger {

	private ArrayList<String> userNames;
	private ArrayList<Message> messagesList;
	
//	// new array of strings
//	private ArrayList<String> 
	
	public Messenger(){
		this.userNames = new ArrayList<String>();
		this.messagesList =  new ArrayList<Message>();
	}
	
	/**
	 * Adds a username into the userNames arraylist. Adds nothing if the username is already in the arraylist and returns voids.
	 *
	 * @param username is a unique name or ID
	 * @return void and does nothing if username already exist in userNames arraylists.
	 */
	void addUser(String username) {
		if(userNames.contains(username)) {
			return;
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
			Message msg = new Message(text, sender, receiver);
			this.messagesList.add(msg);
		}
		else {
			throw new IllegalArgumentException("Either sender or receiver doesn't exist.");
		}
	}
	
	/**
	 * Gets an arraylist of messages that a receiver receives and sets the status type of their message to read if it is unread.
	 * 
	 * @param receiver: Receiver username.
	 * @return Returns a Message Arraylist that contains messages sent to receiever username
	 */
	public ArrayList<Message> getReceivedMessages(String receiver){
		if(!userNames.contains(receiver)) {
			System.out.println(receiver);
			throw new IllegalArgumentException("Receiver not in username list"); 
		}		
		
		if(this.messagesList.isEmpty()) {
			return null;
		}
		
		ArrayList<Message> rcvdMsgList =  new ArrayList<Message>();
		for(Message msg : messagesList) {
			if(receiver.equals(msg.getRecipientUsername())) {
				rcvdMsgList.add(msg);
				if(msg.getStatus() == Message.StatusType.UNREAD) {
					msg.setStatus(Message.StatusType.READ);
				}
			}
		}
		return rcvdMsgList;
	}
	
	/**
	 * Gets an arraylist of messages that a receiver receives which is of type s 
	 * and sets the status type of their message to read if it is unread.
	 * 
	 * @param 	receiver: Receiver username.
	 * 			s: status
	 * @return Returns a Message Arraylist that contains messages sent to receiever username
	 */
	public ArrayList<Message> getReceivedMessages(String receiver, Message.StatusType s){
//		Message rcvdMsg;
		if(!userNames.contains(receiver)) {
			System.out.println(receiver);
			throw new IllegalArgumentException("Receiver not in username list"); 
		}		
		
		if(this.messagesList.isEmpty()) {
			return null;
		}
		ArrayList<Message> rcvdMsgList =  new ArrayList<Message>();
		for(Message msg : messagesList) {
			if((receiver.equals(msg.getRecipientUsername())) && (msg.getStatus() == s)) {
				rcvdMsgList.add(msg);
				if(msg.getStatus() == Message.StatusType.UNREAD) {
					msg.setStatus(Message.StatusType.READ);
				}
			}
		}
		return rcvdMsgList;
	}
	/**
	 * send smile
	 * **/
	public void sendSmile(String from, String to) {
		SmileMessage smile = new SmileMessage(from, to);
		messagesList.add(smile);
	}
	
	/**
	 * a getter for the user ArrayList
	 * 
	 * @return MessageList arraylist
	 * **/
	public ArrayList<String> getUserList(){
		return this.userNames;
	}
}

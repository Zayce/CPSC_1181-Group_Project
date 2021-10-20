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
	
//	// new array of strings
//	private ArrayList<String> 
	
	public Messenger(){
		
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
			Message msg = new Message(text, sender, receiver, Message.StatusType.UNREAD);
			messagesList.add(msg);
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
		userNames.contains(receiver);
		ArrayList<Message> rcvdMsgList =  new ArrayList<Message>();
		for(Message msg : messagesList) {
			if(receiver.equals(msg.getRecipientUsername())) {
				Message rcvdMsg = new Message(msg.getText(), msg.getSenderUsername(), msg.getRecipientUsername(), msg.getStatus());
				rcvdMsgList.add(rcvdMsg);
				if(rcvdMsg.getStatus() == Message.StatusType.UNREAD) {
					rcvdMsg.setStatus(Message.StatusType.READ);
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
		userNames.contains(receiver);
		ArrayList<Message> rcvdMsgList =  new ArrayList<Message>();
		for(Message msg : messagesList) {
			if((receiver.equals(msg.getRecipientUsername())) && (msg.getStatus() == s)) {
				Message rcvdMsg = new Message(msg.getText(), msg.getSenderUsername(), msg.getRecipientUsername(), msg.getStatus());
				rcvdMsgList.add(rcvdMsg);
				if(rcvdMsg.getStatus() == Message.StatusType.UNREAD) {
					rcvdMsg.setStatus(Message.StatusType.READ);
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

/**
 * Message Class
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 * 
 **/


public class Message {
	public enum StatusType {unread, read, starred};
	// unread has value 0, read has value 1, and starred has value 2
	
	private String text;
	private String senderUsername;
	private String recipientUsername;
	private StatusType status;
	private static int messageCount = 0;
	
	/**
	 * constructor 1
	 * four values
	 * **/
	public Message(String t, String sn, String rn, StatusType s) {
		this.text = t;
		this.senderUsername = sn;
		this.recipientUsername = rn;
		this.status = s;
		messageCount++;
	}
	
	/**
	 * constructor 2
	 * 3 values
	 * 
	 * **/
	public Message(String t, String sn, String rn) {
		this.text = t;
		this.senderUsername = sn;
		this.recipientUsername = rn;
		this.status = StatusType.unread;
		messageCount++;
	}
	
	/**
	 * @return the text of the message
	 * **/
	public String getText() {
		return text;
	}
	
	/**
	 * @return the sender's username
	 * **/
	public String getSenderUsername() {
		return senderUsername;
	}
	
	/**
	 * @return the recipient's username
	 * **/
	public String getRecipientUsername() {
		return recipientUsername;
	}
	
	/**
	 * @return the status of the message
	 * **/
	public StatusType getStatus() {
		return status;
	}
	
	/**
	 * set the status of the message
	 * **/
	public void setStatus(StatusType s) {
		status = s;
	}
	
	/**
	 * @return a string with all data
	 * **/
	public String toString() {
		return ("From: " + senderUsername + "\nTo: " + recipientUsername + "\nText: " + text + "\nStatus: " + status);
	}
	
	/**
	 * @return the total number of messages
	 * **/
	public int getMessageCount() {
		return messageCount;
	}

}

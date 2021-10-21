/**
 * Message Class
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 * 
 **/

public class Message {

	public enum StatusType {
		UNREAD, READ, STARRED
	};

	private String text;
	private String senderUsername;
	private String recipientUsername;

	private StatusType status;
	
	private static int messageCount = 0;
	private static int textLength = 0;

	/**
	 * Message constructor with 4 parameters
	 * 
	 * @param t = message text sn = Username of the sender. rn = Username of the
	 *          receiver.
	 * 
	 **/
	public Message(String t, String sn, String rn, StatusType s) {
		this.text = t;
		this.senderUsername = sn;
		this.recipientUsername = rn;
		this.status = s;
		messageCount++;
		textLength += t.length();
	}

	/**
	 * Message constructor with 3 parameters
	 * 
	 * @param t: text sn: Sender username rn: Receiver username
	 **/
	public Message(String t, String sn, String rn) {
		this.text = t;
		this.senderUsername = sn;
		this.recipientUsername = rn;
		this.status = StatusType.UNREAD;
		messageCount++;
		textLength += t.length();
	}

	/**
	 * @return the total number of messages
	 **/
	public int getMessageCount() {
		return messageCount;
	}

	/**
	 * @return the total length of text
	 **/
	public int getTextLength() {
		return textLength;
	}

	/**
	 * @return the text of the message
	 **/
	public String getText() {
		return text;
	}

	/**
	 * @return the sender's username
	 **/
	public String getSenderUsername() {
		return senderUsername;
	}

	/**
	 * @return the recipient's username
	 **/
	public String getRecipientUsername() {
		return recipientUsername;
	}

	/**
	 * @return the status of the message
	 **/
	public StatusType getStatus() {
		return status;
	}

	/**
	 * set the status of the message
	 **/
	public void setStatus(StatusType s) {
		this.status = s;
	}

	/**
	 * @return a string with all data
	 **/
	@Override
	public String toString() {
		String statusString = this.status.toString();
		statusString = statusString.substring(0, 1).toUpperCase() + statusString.substring(1);
		return ("\nFrom: " + this.senderUsername + "\nTo: " + this.recipientUsername + "\nStatus: " + statusString + "\n" + this.text);
	}

}

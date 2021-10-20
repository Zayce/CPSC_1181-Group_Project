/**
 * @author Chendong (Oliver) Zhu
 * @author Zulhelmi (Zoella) Mohamad
 */


import static org.junit.jupiter.api.Assertions.*;
/**
 * 
 * A class for testing the methods of the Message class behave
 * as expected.
 * See: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * For more JUnit Assertion Statements
 **/

import org.junit.jupiter.api.Test;

class TestMessage {

	Message m1 = new Message("Hello!", "Olie", "Zoey");
	
	@Test
	void testText() {
		assertEquals("Hello!", m1.getText());
	}
	
	@Test
	void testSenderUsername() {
		assertEquals("Olie", m1.getSenderUsername());
	}
	
	@Test
	void testRecipientUsername() {
		assertEquals("Zoey", m1.getRecipientUsername());
	}
	
	@Test
	void testStatus() {
		assertEquals(Message.StatusType.UNREAD, m1.getStatus());
	}
	
	@Test
	void testSetStatus() {
		m1.setStatus(Message.StatusType.READ);
		assertEquals(Message.StatusType.READ, m1.getStatus());
	}
	

}
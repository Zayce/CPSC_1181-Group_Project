import static org.junit.jupiter.api.Assertions.*;
/**
 * 
 * A class for testing the methods of the Calculator class behave
 * as expected.
 * See: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * For more JUnit Assertion Statements
 **/

import org.junit.jupiter.api.Test;

class TestMessage {

	Message m1 = new Message("Hello!", "Olie", "Zoey", StatusType.UNREAD);
	Message m2 = new Message("Hi", "Olie", "Zoey");

	//System.out.println("m1 created!");
	
	@Test
	void testGetMessageCount() {
		assertEquals(1, m1.getMessageCount());
	}
	
	@Test
	void testGetTextLength() {
		assertEquals(6, m1.getTextLenght());
	}
	
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
		assertEquals(StatusType.UNREAD, m1.getStatus());
	}
	
	@Test
	void testSetStatus() {
		m1.setStatus(StatusType.READ);
		assertEquals(StatusType.READ, m1.getStatus());
	}
	

}

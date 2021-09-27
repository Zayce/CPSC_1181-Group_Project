package y;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

/**
 * 
 * A class for testing the methods of the Calculator class behave
 * as expected.
 * See: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * For more JUnit Assertion Statements
 **/

public class TestTrain throws Exception {

	@Test
	void testTrain() {
		try {
			Train testTrain1 = new Train(null,0);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Invalid string input", e.getMessage());
		}

		try {
			Train testTrain2 = new Train("",0);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Invalid string input", e.getMessage());
		}

		try {
			Train testTrain3 = new Train("Thomas", -1);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Negative number", e.getMessage());
		}

	}

	@Test
	void testGetSetName() {
		Train thomas = new Train("Thomas",40);
		
		assertEquals("Thomas", thomas.getName());
	}

}



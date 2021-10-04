import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * A class for testing the methods of the Train class behave
 * as expected.
 * See: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * For more JUnit Assertion Statements
 * 
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 **/

public class TestTrain{

	@Test
	void testTrain() {
		Train albert = new Train("Albert", 130);
		assertEquals("Albert", albert.getName());
		assertEquals(130, albert.getPower());
		
		try {
			Train testTrain1 = new Train(null,0);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("String should not be empty or contain null.", e.getMessage());
		}

		try {
			Train testTrain2 = new Train("",0);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("String should not be empty or contain null.", e.getMessage());
		}

		try {
			Train testTrain3 = new Train("Thomas", -1);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Power should not be negative.", e.getMessage());
		}
	}

	@Test
	void testGetSetName() {
		Train thomas = new Train("Thomas",40);
		assertEquals("Thomas", thomas.getName());
		thomas.setName("Tommy");
		assertEquals("Tommy", thomas.getName());
		
		try {
			Train percy = new Train("Percy", 20);
			percy.setName(null);
			assertEquals("Percy", percy.getName());
			fail("Expected an Illegal Argument exception");
		}catch(IllegalArgumentException e) {
			assertEquals("Name should not be null or empty.", e.getMessage());
		}
		
		try {
			Train gordon = new Train("Gordon", 30);
			gordon.setName("");
			assertEquals("Gordon", gordon.getName());
			fail("Expected an Illegal Argument exception");
		}catch(IllegalArgumentException e) {
			assertEquals("Name should not be null or empty.", e.getMessage());
		}
	}

	@Test
	void testGetSetPower(){
		Train thomas = new Train("Thomas",40);
		assertEquals(40, thomas.getPower());
		thomas.setPower(50);
		assertEquals(50, thomas.getPower());

		Train gordon = new Train("Gordon", 30);
		assertEquals(30, gordon.getPower());
		gordon.setPower(0);
		assertEquals(0, gordon.getPower());
		
		try {
			Train percy = new Train("Percy", 20);
			percy.setPower(-1);
			fail("Expected an Illegal Argument exception");
		}catch(IllegalArgumentException e) {
			assertEquals("Power can't be negative.", e.getMessage());
		}
	}
	
	
	@Test
	void testGetTotalWeightOfCars() {
		Train thomas = new Train("Thomas",40);
		thomas.addCars(12,34,23,42,1);
		assertEquals(112, thomas.getTotalWeightOfCars());
		thomas.addCars(34,53);
		assertEquals(199, thomas.getTotalWeightOfCars());
		
		Train peter = new Train("Peter", 32);
		assertEquals(0, peter.getTotalWeightOfCars());
	}
	
	@Test 
	void testGetNumberofCars(){
		Train thomas = new Train("Thomas",40);
		thomas.addCars(12,34,23,42,1);
		assertEquals(5, thomas.getNumberOfCars());
		thomas.addCars(34,53);
		assertEquals(7, thomas.getNumberOfCars());

		Train percy = new Train("Percy", 20);
		assertEquals(0, percy.getNumberOfCars());
	}
	
	@Test
	void testGetMaxSpeed(){
		Train toby = new Train("Toby", 100);
		toby.addCars(12,4,13,19,15);
		assertEquals(37, toby.getMaxSpeed());

		Train dart = new Train("Dart", 50);
		dart.addCars(12,4,13,19,15,23,34,56,76);
		assertEquals(0, dart.getMaxSpeed());
		
		Train porter = new Train("Porter", 300);
		porter.addCars(11,12,13,15,16,17,18);
		assertEquals(150, porter.getMaxSpeed());
		
		Train vict = new Train("Vict", 300);
		vict.addCars(75,75,1);
		assertEquals(149, vict.getMaxSpeed());
		
		Train victor = new Train("Victor", 300);
		victor.addCars(75,75);
		assertEquals(150, victor.getMaxSpeed());
		
		Train victoria = new Train("Victoria", 300);
		victoria.addCars(75,74);
		assertEquals(150, victoria.getMaxSpeed());
		
		Train bill = new Train("Bill", 149);
		assertEquals(149, bill.getMaxSpeed());
		
	}
	
	@Test
	void testToString(){
		Train thomas = new Train("Thomas",40);
		thomas.addCars(12,34,23,42,1);
		assertEquals("This train Thomas has 40 amount of power.\n"
				+ "It has 5 cars that weighs 112 tons in total.", thomas.toString());
	}
	
	@Test
	void testRemoveAllCars(){	
		Train henry = new Train("Henry", 50);
		henry.addCars(3, 2, 4, 5, 64, 54);
		assertEquals(6, henry.getNumberOfCars());
		henry.removeAllCars();
		assertEquals(0, henry.getNumberOfCars());
		
		Train thomas = new Train("Thomas", 30);
		assertEquals(0, thomas.getNumberOfCars());
		thomas.removeAllCars();
		assertEquals(0, thomas.getNumberOfCars());
	}
	
	@Test
	void testAddCars(){
		Train thomas = new Train("Thomas",40);
		thomas.addCars(12,34,23,42,1);
		assertEquals(5, thomas.getNumberOfCars());
		thomas.addCars(34,53);
		assertEquals(7, thomas.getNumberOfCars());
		
		try {
			Train gordon = new Train("Gordon", 20);
			gordon.addCars(null);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Weight input should not be empty or contain null.", e.getMessage());
		}
		try {
			Train emily = new Train("Emily", 20);
			emily.addCars();
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Weight input should not be empty or contain null.", e.getMessage());
		}

		try {
			Train peter = new Train("Peter", 32);
			assertEquals(0, peter.getTotalWeightOfCars());
			peter.addCars(3,43,-34,-1);
			fail("Expected an Illegal Argument exception");
		}catch(IllegalArgumentException e) {
			assertEquals("Weights cannot be negative.", e.getMessage());
		}
	}
	
	@Test
	void testMergeTrains(){
		Train thomas = new Train("Thomas", 150);
		Train percy = new Train("Percy", 170);
		
		thomas.addCars(12,34,23,42,12); // sum weight is 123
		percy.addCars(20,30,20,30,20,31); //sum weight is 151
		
		thomas.mergeTrains(percy); //sum weight should be 274
		assertEquals("Thomas", thomas.getName());
		assertEquals("Percy", percy.getName());
		
		assertEquals(320, thomas.getPower());
		assertEquals(0, percy.getPower());
		
		assertEquals(11, thomas.getNumberOfCars());
		assertEquals(0, percy.getNumberOfCars());
		
		assertEquals(274, thomas.getTotalWeightOfCars());
		assertEquals(0, percy.getTotalWeightOfCars());
		
		assertEquals(46, thomas.getMaxSpeed());
		assertEquals(0, percy.getMaxSpeed());
	}
}
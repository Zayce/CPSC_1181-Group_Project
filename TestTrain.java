import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * A class for testing the methods of the Calculator class behave
 * as expected.
 * See: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * For more JUnit Assertion Statements
 **/

public class TestTrain{

	@Test
	void testTrain() {
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
	void testGetName() {
		Train thomas = new Train("Thomas",40);
		assertEquals("Thomas", thomas.getName());
		
		Train percy = new Train("Percy", 20);
		assertEquals("Percy", percy.getName());
		
		Train gordon = new Train("Gordon", 30);
		assertEquals("Gordon", gordon.getName());
		
	}
	
	@Test
	void testSetName() {
		try {
			Train emily = new Train("Emily", 20);
			emily.setName(null);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Invalid name", e.getMessage());
		}
		
		try {
			Train thomas = new Train("Thomas", 20);
			thomas.setName("");
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Invalid name", e.getMessage());
		}
		
		Train percy = new Train("Percy", 10);
		percy.setName("PERCY");
		assertEquals("PERCY", percy.getName());
	}

	@Test
	void testGetPower(){
		Train thomas = new Train("Thomas",40);
		assertEquals(40, thomas.getPower());
		
		Train percy = new Train("Percy", 20);
		assertEquals(20, percy.getPower());
		
		Train gordon = new Train("Gordon", 30);
		assertEquals(30, gordon.getPower());
	}
	
	@Test
	void testSetPower() {
		try {
			Train emily = new Train("Emily", 20);
			emily.setPower(-100);
			fail("Expected an Illegal Argument exception");
		}	catch(IllegalArgumentException e) {
				assertEquals("Power must not be negative", e.getMessage());
		}
		
		Train percy = new Train("Percy", 10);
		percy.setPower(0);
		assertEquals(0, percy.getPower());
		percy.setPower(100);
		assertEquals(100, percy.getPower());
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
	void testgetMaxSpeed(){
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
		

		assertEquals(0, percy.getMaxSpeed());
		assertEquals(46, thomas.getMaxSpeed());
		
		Train thomas2 = new Train("Thomas2", 150000);
		Train percy2 = new Train("Percy2", 170);
		
		thomas2.addCars(0); // sum weight is 0
		percy2.addCars(20,30,20,30,20,31); //sum weight is 151
		
		thomas2.mergeTrains(percy2); //sum weight should be 151
		assertEquals("Thomas2", thomas2.getName());
		assertEquals("Percy2", percy2.getName());
		
		assertEquals(150170, thomas2.getPower());
		assertEquals(0, percy2.getPower());
		
		assertEquals(7, thomas2.getNumberOfCars());
		assertEquals(0, percy2.getNumberOfCars());
		
		assertEquals(151, thomas2.getTotalWeightOfCars());
		assertEquals(0, percy2.getTotalWeightOfCars());
		
		assertEquals(0, percy2.getMaxSpeed());
		assertEquals(150, thomas2.getMaxSpeed());

	}
	
//	@Test
//	void testtoString() {
//		Train thomas = new Train("Thomas", 150);
//		thomas.addCars(12,34,23,42,12); // sum weight is 123
//		
//		assertEquals("This train Thomas has 150 amount of power.\nIt has 5 that weights 123 tons in total.", toString());
//		
//	}
}


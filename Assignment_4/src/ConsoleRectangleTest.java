//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.Test;
//
///**
// * @author Zulhelmi (Zoella) Mohamad
// * @author Chendong (Oliver) Zhu
// * 
// * Test To see if ConsoleRectangle works
// *
// */
//class ConsoleRectangleTest {
//
//	final double EPSILON = 0.000001;
//	
//	ConsoleRectangle rec1 = new ConsoleRectangle();
//	ConsoleRectangle rec2 = new ConsoleRectangle(true, 2, 3);
//	ConsoleRectangle rec3 = new ConsoleRectangle(false, -5, -7);
//	ConsoleRectangle rec4 = new ConsoleRectangle(true, 8, 14);
//	ConsoleRectangle rec5 = new ConsoleRectangle(true, 14, 8);
//	
//	@Test
//	void testToString(){
//		System.out.println(rec1.toString());
//		System.out.println(rec2.toString());
//		System.out.println(rec3.toString());
//		System.out.println(rec4.toString());
//		System.out.println(rec5.toString());
//
//
//	}
//	
//	@Test
//	void testDrawForConsole(){
//		System.out.println("Rec 1: \n" + rec1.drawForConsole());
//		System.out.println("Rec 2: \n" + rec2.drawForConsole());
//		System.out.println("Rec 3: \n" + rec3.drawForConsole());
//		System.out.println("Rec 4: \n" + rec4.drawForConsole());
//		System.out.println("Rec 5: \n" + rec5.drawForConsole());
//		
//		Billboard bts = new Billboard("BTS should have won the Grammys");
//		System.out.println("BTS: \n" + bts.drawForConsole());
//
//		Billboard oop = new Billboard("Object Oriented Programming is actually fun and not at all tedious. For real and serious, this is my own opinion!");
//		System.out.println("OOP: \n" + oop.drawForConsole());
//
//
//	}
//	
//	@Test
//	void testGetSetHeightWidthIsFilledIn() {
//		ConsoleRectangle rec4 = new ConsoleRectangle();
//		assertEquals(1, rec4.getHeight());
//		assertEquals(1, rec4.getWidth());
//		assertEquals(false, rec4.isFilledIn());
//		rec4.setHeight(7);
//		rec4.setWidth(10);
//		rec4.setFilledIn(true);
//		assertEquals(7, rec4.getHeight());
//		assertEquals(10, rec4.getWidth());
//		assertEquals(true, rec4.isFilledIn());
//		
//		ConsoleRectangle rec5 = new ConsoleRectangle(true, 2, 3);
//		assertEquals(2, rec5.getHeight());
//		assertEquals(3, rec5.getWidth());
//		assertEquals(true, rec5.isFilledIn());
//		
//		ConsoleRectangle rec6 = new ConsoleRectangle(false, 5, 7);
//		assertEquals(5, rec6.getHeight());
//		assertEquals(7, rec6.getWidth());
//		assertEquals(false, rec6.isFilledIn());
//	}
//	
//	@Test
//	void testGetArea() {
//		assertEquals(1, rec1.getArea(), EPSILON);
//		assertEquals(6, rec2.getArea(), EPSILON);
//		assertEquals(35, rec3.getArea(), EPSILON);
//	}
//	
//	@Test
//	void testGetPerimeter(){
//		assertEquals(4, rec1.getPerimeter());;
//		assertEquals(10, rec2.getPerimeter());
//		assertEquals(24, rec3.getPerimeter());
//	}
//	
//}

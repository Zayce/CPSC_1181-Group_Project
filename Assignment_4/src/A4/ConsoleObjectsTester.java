import java.util.Arrays;
import java.util.Collections;

/**
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 */
public class ConsoleObjectsTester {
	final int LENGTH = 5;
	
	private ConsoleShape shapeArr[] = new ConsoleShape[LENGTH];
	private ConsoleDrawable shapeDrawn[] = new ConsoleDrawable[LENGTH + 3];
	
	public static void main(String[] args) {
		ConsoleObjectsTester prog = new ConsoleObjectsTester();
		prog.execute();
	}
	
	public ConsoleObjectsTester() {
		
		ConsoleRectangle rec1 = new ConsoleRectangle(true, 2, 3);
		ConsoleRectangle rec2 = new ConsoleRectangle(true, 14, 8);
		ConsoleRectangle rec3 = new ConsoleRectangle(false, -5, -7);
		ConsoleRectangle rec4 = new ConsoleRectangle();
		ConsoleRectangle rec5 = new ConsoleRectangle(true, 8, 14);

		shapeArr[0] = rec1;
		shapeArr[1] = rec2;
		shapeArr[2] = rec3;
		shapeArr[3] = rec4;
		shapeArr[4] = rec5;
		
		ConsoleDrawable recDraw1 = rec1;
		ConsoleDrawable recDraw2 = rec2;
		ConsoleDrawable recDraw3 = rec3;
		ConsoleDrawable recDraw4 = rec4;
		ConsoleDrawable recDraw5 = rec5;

		shapeDrawn[0] = recDraw1;
		shapeDrawn[1] = recDraw2;
		shapeDrawn[2] = recDraw3;
		shapeDrawn[3] = recDraw4;
		shapeDrawn[4] = recDraw5;
		shapeDrawn[5] = new Billboard("BTS should have won the Grammys");
		shapeDrawn[6] = new Billboard("Object Oriented Programming is actually fun and not at all tedious. For real and serious, this is my own opinion!");
		shapeDrawn[7] = new Billboard("Writing's not easy. That's why Grammarly can help. This sentence is grammatically correct, but it's wordy, and hard to read. "
				+ "It undermines the writer's message and the word choice is bland. Grammarly's cutting edge technology helps you craft compelling, understandable writing that makes an impact on your reader. "
				+ "Much better. Are you ready to give it a try? Installation is simple and free. Visit Grammarly.com today!");
	}
	
	public void execute() {
		Arrays.sort(shapeArr);
		
		System.out.println("Rectangles sorted by area: ");
		for(int i = 0; i < LENGTH; i++) {
			System.out.println("Shape " + i + ": \n");
			System.out.println(shapeArr[i].drawForConsole());
		}
		
		System.out.println("ConsoleDrawable Output: ");
		for(int i = 0; i < LENGTH + 3; i++) {
			System.out.println("ConsoleDrawable " + i + ": \n");
			System.out.println(shapeDrawn[i].drawForConsole());
		}
		
		//Below doesn't work yet
		//Collections.sort(shapeArr, new PerimeterComparator());
		System.out.println("PerimeterComparator sorted in decreasing order of permiteer: ");
			for(int i = 0; i < LENGTH; i++) {
				System.out.println("PerimeterComparator " + i + ": \n");
				System.out.println(shapeArr[i].drawForConsole());
			}

	}
}

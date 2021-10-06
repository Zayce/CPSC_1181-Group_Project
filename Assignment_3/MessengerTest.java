import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 * 
 */

class MessengerTest {

	/**
	 * MessengerTest that checks if Messenger class is working.
	 * 
	 * @return nothing but outputs the Messages received between Zoey and Oliver.
	 */
	@Test
	public static int main() {
		Messenger fb = new Messenger();
		fb.addUser("Zoey");
		fb.addUser("Oliver");
		fb.sendMessage("Zoey", "Oliver", "Foo");
		fb.sendMessage("Zoey", "Oliver", "Bar");
		
		fb.sendMessage("Oliver", "Zoey", "Marco Polo");
		
		fb.getReceivedMessages("Zoey");
		cout << fb.toString() << endl;

		fb.getReceivedMessages("Oliver", StatusType.STARRED); //should not return anything
		cout << fb.toString() << endl;

		
	}

}

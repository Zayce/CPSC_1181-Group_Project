/**
 * @author Chendong (Oliver) Zhu
 * @author Zulhelmi (Zoella) Mohamad
 */

public class SmileMessage extends Message{
	private final static String SMILE = 
			" @  @ \n" +
			" 	   \n" + 
			"@    @\n" +
			" @  @ \n" +
			"  @@  \n";
	
	public SmileMessage(String from, String to) {
		super(SMILE, from, to);
	}

}

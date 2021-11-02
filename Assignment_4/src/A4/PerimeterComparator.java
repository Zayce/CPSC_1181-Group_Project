import java.util.Comparator;

/**
 * @author Zulhelmi (Zoella) Mohamad
 * @author Chendong (Oliver) Zhu
 */
public class PerimeterComparator implements Comparator<ConsoleShape> {

	/**
	 * Comparator class to compare ConsoleShape by perimeter in decreasing order
	 * 
	 * @param	csA: Left ConsoleShape
	 * 			csB: Right ConsoleShape
	 * 
	 * @return	+ve if csA's perimeter < cSB's perimeter
	 * 			0 if they're both equal
	 * 			-ve if csA's perimeter > cSB's perimeter
	 */
	@Override
	public int compare(ConsoleShape csA, ConsoleShape csB) {
		if(csA == null || csB == null) {
			throw new NullPointerException("At least one ConsoleShape points to null"); 
		}
		
		return Integer.compare(csB.getPerimeter(), csA.getPerimeter());
	}

}

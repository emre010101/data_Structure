package TABA;

/**
 * 
 * @author Emre Kavak
 * @date 06/05/2023
 * TreeEmptyException.java
 */

public class TreeEmptyException  extends RuntimeException {
	public TreeEmptyException() {
		// simply print out an error message
		super("There is no family member here!");
	}
}

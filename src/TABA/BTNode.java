package TABA;

/**
 * 
 * @author Emre Kavak
 * @date 06/05/2023
 * BTNode.java
 */

public class BTNode<T> {

	// declaring the element type T variable and left and right nodes
	protected T element;
	protected BTNode<T> left;
	protected BTNode<T> right;

	// construct the node
	public BTNode(T element) {
		this.element = element;
	}

	@Override
	public String toString() {
		// if left == null ? return "Null" otherwise return a string representation of the left element
        String leftVal = (left == null ? "NULL" : left.element.toString());
        // if right == null ? return "Null" otherwise return a string representation of the right element
        String rightVal = (right == null ? "NULL" : right.element.toString());
        // return this level, left side of the tree and right side of tree
        return "[Current Person] "+element + "\n[left]" + leftVal + "\n[right]" + rightVal +"\n";
	}




}

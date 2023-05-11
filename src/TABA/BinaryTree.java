package TABA;

/**
 * 
 * @author Emre Kavak
 * @date 06/05/2023
 * BinaryTree.java
 */
/*Interface for BinaryTree all the required methods will be declared here*/
public interface BinaryTree <T extends Comparable <T>>{

	// check if the tree is empty
	public boolean isEmpty();

	// add nodes into the tree
	public void insert(T element);

	// count all the nodes
	public int size();

	// find the family member at the oldest age
	public T findOldest();

	// find the family member at the youngest age
	public T findYoungest();
	
	// percentage split based on gender
	public String genderPercentage();
	
	// remove Person object based on Name
	public void remove(String name);

	// print out a representation of the tree
	public void inOrder();

}

package TABA;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Emre Kavak
 * @date 06/05/2023 BinaryTreeImpl.java
 */

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {

	// declaring root node
	protected BTNode<T> root;

	public boolean isEmpty() {
		// if root is null, the tree is empty
		return root == null;
	}

	public void insert(T element) {
		// if the tree was empty, root need to be added
		if (isEmpty()) {
			root = new BTNode<>(element);
		} else {
			// if the tree had a root, make use of helper method for comparing with the root to insert in correct position
			insert(element, root);
		}
	}

	private void insert(T element, BTNode<T> current) {
		// if the person is older than the current person
		if (element.compareTo(current.element) == 1) {
			// add it to the right
			if (current.right == null) {
				current.right = new BTNode<>(element);
			} else {
				// recurse call to the sub-right tree
				insert(element, current.right);
			}

			// if the person younger than the current node
		} else {
			// add it to the left
			if (current.left == null) {
				current.left = new BTNode<>(element);
			} else {
				// calling recursively to the left tree
				insert(element, current.left);
			}
		}
	}

	public int size() {
		// use root to find out the size
		return size(root);
	}

	// private helper method used to find the length
	private int size(BTNode<T> current) {
		// if root is null
		if (current == null) {
			// the size is 0, tree is empty
			return 0;
		} else {
			// if not, count left and right subtree nodes
			return 1 + size(current.left) + size(current.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(BTNode<T> current) {
		// if there are no persons in the family
		if (current == null) {
			return;
		}
		// otherwise return right node (older person), current person, and left node (younger person)
		//The left tree which has lover age will be traversed then right tree old people
		//First should be the youngest person and last should be the oldest person
		inOrder(current.left);
		System.out.println(current);
		inOrder(current.right);

	}

	@Override
	public T findOldest() {
		// if the tree is empty
		if (isEmpty()) {
			throw new TreeEmptyException();
		} else {
			// if the tree is not empty,
			return findOldest(root);
		}
	}

	//The most right leaf is the one 
	private T findOldest(BTNode<T> current) {
		// base case for recursive call
		if (current.right == null) {
			//if it's null means that we are at the very corner of right tree
			return current.element;

		} else {
			// keep moving to the right node
			return findOldest(current.right);
			
		}
	}

	@Override
	public T findYoungest() {
		// if the tree is empty
		if (isEmpty()) {
			throw new TreeEmptyException();
		} else {
			// if the tree is not empty, call with the root the helper method
			return findYoungest(root);
		}
	}

	private T findYoungest(BTNode<T> current) {
		// base case for recursive call
		if (current.left == null) {
			//if there are not more nodes to visit
			return current.element;
		} else {
			// keep moving to the left node
			return findYoungest(current.left);
		}
	}

	@Override
	public String genderPercentage() {
	    int menCount = countGenders(root, "Male");
	    int womenCount = countGenders(root, "Female");
	    int totalCount = menCount + womenCount; //the size of the family
	    
	    if (totalCount == 0) {
	        return "No people in the family."; //default message
	    }
	    //Finding the percentage
	    double menPercentage = (double) menCount / totalCount * 100;
	    double womenPercentage = (double) womenCount / totalCount * 100;
	    
	    String out = String.format("The percentage of men is %.2f%%, and the percentage of women is %.2f%% in the family.", menPercentage, womenPercentage);
	    return out;
	}

	//It will traverse the entire tree too look for passed gender count
	private int countGenders(BTNode<T> current, String gender) {
	    if (current == null) {//recursive base
	        return 0;
	    }
	    
	    Person currentPerson = (Person) current.element;
	    int count = 0;
	    
	    if (currentPerson.sex.equals(gender)) {
	        count++; //incrementing if the gender is same as the paramater
	    }
	    
	    count += countGenders(current.left, gender);//check left
	    count += countGenders(current.right, gender);//check right
	    return count;
	}

	@Override
	public void remove(String name) {
	    // Find the Person Object which has this name
	    Person targetPerson = findPersonByName(root, name);
	    
	    // If the person is found, remove the person by their age
	    if (targetPerson != null) {
	    	//if the node want to be removed root itself it will be set to null
	        root = remove(root, (T) targetPerson); //It casted to T
	    }
	}

	/*
	 * The all the tree need to be traversed trough
	 * Because it's structured by the age and it can't be located by name 
	 *
	 * */
	private Person findPersonByName(BTNode<T> current, String name) {
	    if (current == null) {
	        return null;
	    }
	    
	    Person currentPerson = (Person) current.element;
	    // Base case for the recursive call
	    if (currentPerson.getName().equals(name)) {
	        return currentPerson;
	    }
	    //Looking at the left tree
	    Person leftResult = findPersonByName(current.left, name);
	    if (leftResult != null) {
	        return leftResult;
	    }
	    // Looking at the right tree
	    return findPersonByName(current.right, name);
	}

	/*The target node has been found in this stage
	 * we can iterate over to tree efficiently traversing to left or right
	 * using compareTo method
	 * Balancing also will be made here*/
	private BTNode<T> remove(BTNode<T> current, T element) {
	    if (current == null) { //if is empty
	        return null;
	    }
	    //Using the overwritten compareTo method in person class
	    int comparison = element.compareTo(current.element);

	    //if it's younger
	    if (comparison < 0) {
	        current.left = remove(current.left, element);
	        //if it's older
	    } else if (comparison > 0) {
	        current.right = remove(current.right, element);
	        //
	    } else {
	        if (current.left == null && current.right == null) {
	            return null;
	        } else if (current.left == null) {
	            return current.right;
	        } else if (current.right == null) {
	            return current.left;
	        } else {
	            current.element = (T) findYoungest(current.right);
	            current.right = remove(current.right, current.element);
	        }
	    }

	    return current;
	}




}

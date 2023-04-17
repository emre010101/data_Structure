package BinaryTresSolutions;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {

	protected BTNode<T> root;

	// LST < RST at all the stages

	public void insert(T elem) {

		if (isEmpty()) {
			// update root node
			root = new BTNode<>(elem);

		} else {

			insertNode(elem, root);

		}

	}

// we are focused on using the compareTo
	private void insertNode(T elem, BTNode<T> current) {
		// find a place to insert the element
		// compare the element with the root
		if (elem.compareTo(current.element) == -1) {
			// add to the left
			if (current.left == null) {
				current.left = new BTNode<>(elem);
			} else {
				// recurse down the sub-tree rooted at current.left
				insertNode(elem, current.left);
			}
			// similarly for the right
		} else {
			if (current.right == null) {
				current.right = new BTNode<>(elem);
			} else {
				// recurse down the sub-tree rooted at current.left
				insertNode(elem, current.right);
			}
		}
	}

	public boolean isEmpty() {
		// empty tree
		return root == null;
	}

	// lowest values first
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(BTNode<T> current) {
		// base case
		if (current == null) {
			return;
		}
		inOrder(current.left);
		System.out.println(current);
		inOrder(current.right);
		//System.out.println(current);
	}

	public int size() {
		return size(root);
	}

	private int size(BTNode<T> current) {
		if (current == null) {
			return 0;
		} else {
			return 1 + size(current.left) + size(current.right);
		}
	}

	public T findMax() {
		if (isEmpty()) {
			throw new TreeEmptyException();
		} else {
			return findMax(root);
		}
	}

	// bigger elements are in right subtree
	private T findMax(BTNode<T> current) {
		// base case
		if (current.right == null) {

			return current.element;

		} else {

			return findMax(current.right);

		}

	}

	public T findMin() {
		if (isEmpty()) {

			throw new TreeEmptyException();

		} else {
			return findMin(root);

		}

	}

	private T findMin(BTNode<T> current) {
		// base case
		if (current.left == null) {
			return current.element;
		} else {
			return findMin(current.left);
		}
	}

	public boolean contains(T element) {
		return contains(element, root);
	}

	private boolean contains(T element, BTNode<T> current) {
		String currentPos = (current == null ? "NULL" : current.element.toString());
		System.out.println("Searching for " + element + " currently at " + currentPos);
		if (current == null) {
			return false;
		}

		if (element.compareTo(current.element) == 0) {
			System.out.println("We found equality");
			return true;
		} else if (element.compareTo(current.element) <= -1) {
			System.out.println("We are going to the left");
			return contains(element, current.left);
		} else {
			System.out.println("Going to the right");
			return contains(element, current.right);
		}
	}

	private BTNode<T> findNode(T elem) {
		return findNode(elem, root);
	}

// here we are looking for a Node in the Tree
// this method returns a Object of type BTNode

	private BTNode<T> findNode(T elem, BTNode<T> current) {
		if (current == null) {
			return null;
		}
		// if we get a match on the element we return the NTNode...
		if (current.element.equals(elem)) {
			return current;
		} else if (current.element.compareTo(elem) == -1) {
			return findNode(elem, current.right);
		} else {
			return findNode(elem, current.left);
		}
	}

	public boolean remove(T element) {
		// we need to locate the node which we must remove
		BTNode<T> toRemove = findNode(element);
		if (toRemove == null) {
			System.out.println("not found");
			return false;
		}
		System.out.println("toRemove = " + toRemove);
		// we need to find its parent as well
		BTNode<T> parent = findParent(element);
		System.out.println("parent = " + parent);

		// to do the simplest case which is the removal of a leaf node
		if (toRemove.left == null && toRemove.right == null) {
			// determine which child it is
			if (toRemove.element.compareTo(parent.element) == -1) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return true;
		} else if (toRemove.left != null && toRemove.right == null) {
			// in this case the node has a left child but no right child.
			if (toRemove.element.compareTo(parent.element) == -1) {
				// the removed node is the left child
				parent.left = toRemove.left;
			} else {
				// it's the right child
				parent.right = toRemove.left;
			}
			return true;
		} else if (toRemove.left == null && toRemove.right != null) {
			if (toRemove.element.compareTo(parent.element) == -1) {
				parent.left = toRemove.right;
			} else {
				parent.right = toRemove.right;
			}
			return true;
		} else if (toRemove.left != null && toRemove.right != null) {
			// this is the point at where we have objects to the left and to the right....

			// it has both a left and right child
			// find the max value in the left subtree rooted at the current node
			T minValue = findMin(toRemove.right);// we are finding the minimum Node in the right sub tree..
			// We know that when we are searching for the minimum Node we recursively search
			// by passing in the
			// the left pointer starting at a particular Node.
			// The starting point is the point of the new subtree

			// find the Node
			BTNode<T> replacement = findNode(minValue);

			// find the parent
			BTNode<T> replacementParent = findParent(minValue);
			System.out.println("replacementParent = " + replacementParent);

			/*
			 * T maxValue = findMax(toRemove.left); System.out.println("maxValue = " +
			 * maxValue); BTNode<T> replacement = findNode(maxValue); BTNode<T>
			 * replacementParent = findParent(maxValue);
			 */

			replacementParent.left = null;
			toRemove.element = replacement.element;
			return true;
		}
		System.out.println("parent = " + parent);
		return false;
	}

	private BTNode<T> findParent(T element) {
		return findParent(element, root);
	}

	private BTNode<T> findParent(T element, BTNode<T> current) {
		// special case
		if (element.equals(root.element)) {
			return null;
		}
		if (element.compareTo(current.element) == -1) {
			if (current.left == null) {
				// not in the tree
				return null;
			} else if (element.compareTo(current.left.element) == 0) {
				return current;
			} else {
				return findParent(element, current.left);
			}
		} else {
			if (current.right == null) {
				return null;
			} else if (element.compareTo(current.right.element) == 0) {
				return current;
			} else {
				return findParent(element, current.right);
			}
		}
	}

//this is the main method that is executed once you run the code.
	public static void main(String[] args) {

		// we are setting up a BinaryTree called numbers of type Integer
		BinaryTree<Integer> numbers = new BinarySearchTree<>();

		// we insert a Node 12...this node becomes the root of the Tree...
		numbers.insert(12);

		// we are adding in the Node 4....
		numbers.insert(4);
		numbers.insert(6);
		numbers.insert(5);
		numbers.insert(8);
		numbers.insert(34);
		numbers.insert(100);
		numbers.insert(2);

		System.out.println("------------------");
		numbers.inOrder();

		System.out.println("------------------");
		System.out.println("Size of BST: " + numbers.size());

		System.out.println("------------------");
		System.out.println("Max elem of BST: " + numbers.findMax());

		System.out.println("------------------");
		System.out.println("Min elem of BST: " + numbers.findMin());

		System.out.println("______________________");
		numbers.remove(4);

		System.out.println("______________________");
		numbers.inOrder();

		System.out.println("______________________");
	}

}

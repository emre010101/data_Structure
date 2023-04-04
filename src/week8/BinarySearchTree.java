package week8;

//we are going to create our Binary Search Tree
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
// we need out binary search tree to be able to compare objects and implement our interface

//we know that in our tree we are going to need a root Node.
	protected BTNode<T> root;

	public BinarySearchTree() {
	}

	public boolean isEmpty() {
		// we need to return a boolean which is the result of a test to check if the
		// tree is empty
		return root == null;
	}

	public int size() {
		// we need to be able to travers the tree...
		return size(root);
	}

	private int size(BTNode<T> current) {
		// everytime we see a Node we have to add one to a counter...
		if (current == null) { // if the Node doesn't exist return 0
			return 0;
		} else {
			// with the else we are saying that we found a node.
			// we should increment our counter and then search the left and right subtrees.
			// we know in trees that we have a left subtree and a right subtree...
			return 1 + size(current.left) + size(current.right);
		}
	}

	// This is the method that is going to add in an element
	// remember its very important to read the comments before typing
	// sometimes you shouldn't be typing
	public void insert(T elem) {
		// we normally want to know if there is something in the tree
		if (isEmpty()) {
			root = new BTNode<>(elem);
		} else {
			insertNode(elem, root);
		}
	}

	// the goal of this method is to place the new object in its correct position
	private void insertNode(T elem, BTNode<T> current) {
		// we are going to start the search for the position
		if (elem.compareTo(current.element) == -1) {
			// when the comparison is less than zero the new object is less and must be
			// placed in the
			// left subtree.
			if (current.left == null) {
				// this is where there is no child Node and we place the new object as the child
				// node
				current.left = new BTNode<>(elem);
			} else {
				insertNode(elem, current.left);
			}
		} else { // this else is called when the new Node is greater than the object that we are
					// comparing
			if (current.right == null) { // if there is no child Node on the right
				current.right = new BTNode<>(elem);// we create the child Node on the right
			} else {// there was a child Node on the right...
				insertNode(elem, current.right);
			}
		}

	}

	/**
	 * This method locates and returns the largest value stored in the tree as
	 * defined by it location in the tree
	 * 
	 * @return
	 */
	public T findMax() {
		// this is going to be the object in the rightmost part of the tree...
		if (isEmpty()) {
			throw new TreeEmptyException();
		} else {
			return findMax(root);
		}
	}

	private T findMax(BTNode<T> current) {
		// we know the smallest value is going to be on the left
		if (current.right == null) {
			return current.element;
		} else {
			return findMin(current.right);
		}
	}

	/**
	 * This method locates and returns the smallest value stored in the tree as
	 * defined by it location in the tree
	 * 
	 * @return
	 */
	public T findMin() {
		// this is going to be the object in the leftmost part of the tree...
		// we need to search through the tree and find the Node at the bottom left
		if (isEmpty()) {
			throw new TreeEmptyException();
		} else {
			return findMin(root);
		}
	}

	private T findMin(BTNode<T> current) {
		// we know the smallest value is going to be on the left
		if (current.left == null) {
			return current.element;
		} else {
			return findMin(current.left);
		}
	}

	public boolean contains(T element) {
		if (isEmpty()) {
			throw new TreeEmptyException();
		} else {
			return contains(element, root);
		}
	}

	private boolean contains(T element, BTNode<T> current) {
		if(current == null) {
			return false;
		}
		if (current.element.compareTo(element) == 0) {
			return true;
		} else if (current.element.compareTo(element) == -1) {
			return contains(element, current.right);
		} else {
			return contains(element, current.left);
		}
	}

	/*public boolean remove(T element) {
			if(isEmpty()){
				throw new TreeEmptyException();
			}else if()
			return true;
		}*/

	
	@Override
	public void inOrder() {
		inOrder(root);
	}
	

	private void inOrder(BTNode<T> current) {
		// TODO Auto-generated method stub
		if(current==null) {
			return;
		}
		inOrder(current.left);
		System.out.println(current.toString());
		inOrder(current.right);
	}
	
    private BTNode<T> findNode(T elem, BTNode<T> current){
        if (current == null){
            return null;
        }
        // if we get a match on the element we return the NTNode...
        if (current.element.compareTo(elem)==0){
            return current;
        } else if (current.element.compareTo(elem) == -1){
            return findNode(elem, current.right);
        } else {
            return findNode(elem, current.left);
        }
    }
    public BTNode<T> findNode(T elem){
        return findNode(elem, root);
    }

	public boolean remove(T element) {
        // we need to locate the node which we must remove
        BTNode<T> toRemove = findNode(element);
        if (toRemove == null){
            System.out.println("not found");
            return false;
        }
        System.out.println("toRemove = " + toRemove);
        // we need to find its parent as well
        BTNode<T> parent = findParent(element);
        System.out.println("parent = " + parent);

        // to do the simplest case which is the removal of a leaf node
        if (toRemove.left == null && toRemove.right == null){
            // determine which child it is
            if (toRemove.element.compareTo(parent.element) == -1){
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;
        } else if (toRemove.left != null && toRemove.right == null){
            // in this case the node has a left child but no right child.
            if (toRemove.element.compareTo(parent.element) == -1){
                // the removed node is the left child
                parent.left = toRemove.left;
            } else {
                // it's the right child
                parent.right = toRemove.left;
            }
            return true;
        } else if (toRemove.left == null && toRemove.right != null){
            if (toRemove.element.compareTo(parent.element) == -1){
                parent.left = toRemove.right;
            } else {
                parent.right = toRemove.right;
            }
            return true;
        } else if (toRemove.left != null && toRemove.right != null){
          //this is the point at where we have objects to the left and to the right....

            // it has both a left and right child
            // find the max value in the left subtree rooted at the current node
            T minValue = findMin(toRemove.right);// we are finding the minimum Node in the right sub tree..
            // We know that when we are searching for the minimum Node we recursively search by passing in the
            // the left pointer starting at a particular Node.
            // The starting point is the point of the new subtree

            //find the Node
            BTNode<T> replacement = findNode(minValue);

            //find the parent
            BTNode<T> replacementParent = findParent(minValue);
            System.out.println("replacementParent = " + replacementParent);

            /*
                T maxValue = findMax(toRemove.left);
                System.out.println("maxValue = " + maxValue);
                BTNode<T> replacement = findNode(maxValue);
                BTNode<T> replacementParent = findParent(maxValue);
           */

            replacementParent.left = null;
            toRemove.element = replacement.element;
            return true;
        }
        System.out.println("parent = " + parent);
        return false;
    }
    public BTNode<T> findParent(T element) {
        return findParent(element, root);
    }

    private BTNode<T> findParent(T element, BTNode<T> current) {
        // special case
        if (element.compareTo(root.element)==0){
            return null;
        }
        if (element.compareTo(current.element) == -1){
            if (current.left == null){
                // not in the tree
                return null;
            } else if (element.compareTo(current.left.element) == 0){
                return current;
            } else {
                return findParent(element, current.left);
            }
        } else {
            if (current.right == null){
                return null;
            } else if (element.compareTo(current.right.element) == 0) {
                return current;
            } else {
                return findParent(element, current.right);
            }
        }
    }

	public static void main(String[] args) {

		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();
		myTree.insert(15);
		myTree.insert(50);
		myTree.insert(32);
		myTree.insert(22);
		System.out.println(myTree.contains(15));
		System.out.println(myTree.size());
		myTree.inOrder();
		myTree.remove(32);
		myTree.inOrder();
	}



}
package week8;

public class BSTInteger extends BinarySearchTree<Integer>{

	public void findEven() {
		findEven(root);
	}

	private void findEven(BTNode<Integer> current) {
		if(current ==null) {
			return;
		}
		findEven(current.left);
		if((current.element % 2) == 0) {
			System.out.println("Num Found = " + current.element);;
		}
		findEven(current.right);
	}
	
	public int multiply() {
		return multiply(root);
	}

	private int multiply(BTNode<Integer> current) {
		if(current.left == null && current.right == null) {
			return current.element;
		}else if(current.left == null && current.right != null) {
			return current.element * multiply(current.right);
		}else if(current.left != null && current.right == null) {
			return current.element * multiply(current.left);
		}else {
			return current.element * multiply(current.right) * multiply(current.left);
		}
	}
	
	public int sum() {
		return sum(root);
	}

	private int sum(BTNode<Integer> current) {
		if(current.left == null && current.right == null) {
			return current.element;
		}else if(current.left==null && current.right != null) {
			return current.element + sum(current.right);
		}else if(current.left != null && current.right == null) {
			return current.element + sum(current.left);
		}else {
			return sum(current.left) + sum(current.right);
		}
	}
	
	public static void main(String[] args) {
		BSTInteger myInt = new BSTInteger();
		myInt.insert(15);
		myInt.insert(16);
		myInt.insert(18);
		myInt.insert(7);
		myInt.inOrder();
		myInt.remove(7);
		myInt.inOrder();
		System.out.println(myInt.sum());
		System.out.println(myInt.multiply());
		System.out.println(myInt.size());
	}
}

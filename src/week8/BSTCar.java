package week8;

public class BSTCar extends BinarySearchTree<Car>{


	/*@Override
	public void insert(Car elem) {
		if(isEmpty() == true) {
			root = new BTNode<Car>(elem);
		}else {
			insertCar(elem, root);
		}
	}

	/*First locate where we will put the new car element then place it*/
	/*private void insertCar(Car elem, BTNode<Car> current) {
		if(elem.compareTo(current.element)==-1) {
			if(current.left==null) {
				current.left = new BTNode<Car>(elem);
			}else {
				insertCar(elem, current.left);
			}
		}else {
			if(current.right == null) {
				current.right = new BTNode<Car>(elem);
			}else {
				insertCar(elem, current.right);
			}
		}
	}*/

	//@Overloading
	public boolean remove(int id) {
		Car car = findCarByID(id);
		if(car != null) {
			return super.remove(car);
		}
		return false;
	}

	private Car findCarByID(int id) {
		return findCarByID(root, id);
	}


	private Car findCarByID(BTNode<Car> node, int id) {
	    if (node == null) {
	        return null;
	    }
	    System.out.printf("Searching %s in node: %s", id, node.element.getID());
	    System.out.println();
	    if (node.element.getID() == id) {
	        return node.element;
	    }
	    Car leftResult = findCarByID(node.left, id);
	    if (leftResult != null) {
	        return leftResult;
	    }
	    return findCarByID(node.right, id);
	}

	//@Overloading
	public boolean contains(int id) {
		Car car = findCarByID(id);
		if(car != null) {
			System.out.println("contains test in if is not empty");
			return super.contains(car);
		}else {
			System.out.println("contains test in if is empty");
			return false;
		}
		
	}

	public static void main(String[] args) {
		BSTCar cars = new BSTCar();
		cars.insert(new Car("Hyundai", "Red", 2015, 20));
		cars.insert(new Car("Mercedes", "Blue", 2018, 10));
		cars.insert(new Car("Renault", "White", 2005, 31));
		cars.insert(new Car("Tofas", "Black", 1997, 5));
		cars.insert(new Car("Opel", "Gray", 2023, 4));
		
		cars.inOrder();
		System.out.println("Before remove : " + cars.size());
		cars.remove(10);
		System.out.println("After remove : " + cars.size());
		cars.inOrder();
		System.out.println(cars.contains(20));
		System.out.println("true : " + cars.contains(31));
		
		
	}
	
}

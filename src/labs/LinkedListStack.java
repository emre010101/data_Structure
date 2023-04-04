package labs;

public class LinkedListStack<T> implements Stack<T> {
	private Node<T>	first;
	//private Node<T> last;
	
	public LinkedListStack(){
		//first = null;
		//last = null;
	}
	
	public T peek() {
		if(first==null) {throw new IndexOutOfBoundsException();}
		else {
			T value = first.element;
			return value;
		}
	}
	
	public void push(T elem) {
		if(isEmpty()){
			first = new Node<>(elem, null);
		}
		else {
			//Node<T> oldFirst = first;
			first = new Node<T>(elem, first);
			//last.next = new Node<T>(elem);
			//last = last.next;
		}
	}
	public boolean isEmpty() {
		return first == null;
	}
	
	public T pop() {
		if(isEmpty()) {throw new IndexOutOfBoundsException();}
		else {
			T value = first.element;
			first = first.next;
			return value;
		}
	}
	
	public String toString() {
		String out= "TOP\n";
		Node<T> current = first;
		//int count = top; we use this in array
		while(current != null) {
			out += current.element + "\n";
			current = current.next;
		}
		return out+="BOTTOM";
	}
	
	public static void main (String args []) {
		LinkedListStack<Integer> linkedstack = new LinkedListStack<>();
		linkedstack.push(15);
		/*linkedstack.push(45);
		linkedstack.push(31);
		linkedstack.push(99);
		linkedstack.pop();*/
		linkedstack.peek();
		//System.out.println(linkedstack.toString());
	}
	
	
}

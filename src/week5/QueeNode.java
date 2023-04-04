package week5;

/*construct queue using a single LinkedList
 * each Node in the LinkedList will have a data piece and a pointer to the next Node
 */

public class QueeNode<T> {
	T element;
	QueeNode<T> next;
	
	//Constructors
	public QueeNode(T el){
		this.element = el;
		this.next = null;
	}
	
	public QueeNode(T el, QueeNode<T> n) {
		this.element = el;
		this.next = n;
	}

	@Override
	public String toString() {
		return "QueeNode [element=" + element + ", next=" + next + "]";
	}
	
	public static void main(String[] args) {
		String em= "emre";
		QueeNode erm = new QueeNode<>(em);
		System.out.println(erm.toString());
		
	}
}

package extraIMP;

public class Node<T> {
	T element;
	Node<T> next;
	
	public Node(T el){
		this.element = el;
		this.next = null;
	}
	
	public Node(T el, Node<T> gel) {
		this.element = el;
		this.next = gel;
	}
	
	public String toString() {
		return "Node<T> " + "element: " + element;
	}
	
	public static void main(String[] args) {
		Node em = new Node("emre");
		System.out.println(em.toString());
	}
}

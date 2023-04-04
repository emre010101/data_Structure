package carRecordsDL;

public class NodeDL<T>{
	T element;
	NodeDL<T> previous;
	NodeDL<T> successor;
	
	public NodeDL(T el, NodeDL<T> prev, NodeDL<T> succ) {
	    this.element = el;
	    this.previous = prev;
	    this.successor = succ;
	}
	public NodeDL(T el) {
		this.element = el;
		this.previous = null;
		this.successor = null;
	}
	
	public NodeDL(T el, NodeDL<T> prev) {
		this.element = el;
		this.previous = prev;
		this.successor = null;
	}
	@Override
	public String toString() {
	    return "DLNode{" + "element=" + element + "}";
	}
}

package labs;
	/*
	we need a reference to the first and last Nodes in the LinkedList
	We need the following methods:
		- we need to check if the list is empty
*/
public class Linkedlist<T> implements List<T>{
	private Node<T> first;
	private Node<T> last;

	public Linkedlist(){
		first = null;
		last = null;
	}

	//Test to see if the linkedlist is empty
	public boolean isEmpty(){
		return first == null;
	}

	//Calculate the number of elements in the linkedlist
	public int size(){
		int count = 0;
		Node<T> current = first;
		//we need a loop to keep moving through our linkedlist
		while(current !=null){
			count++;
			current = current.next;
		}
		return count;
	}

	//method to add an element into the linkedlist
	public void add(T el){
		if(isEmpty()){
			//if its empty do something
			first = new Node<T>(el);
			last = first;
		}else{
			//there is something in the list we need to
			//add at the end of the list
			last.next = new Node<T>(el);
			last = last.next;
		}

	}
	public void add(int index, T el) {
		Node<T> current = first;
		for(int i=0; i<index-1; i++) {
			current = current.next;
		}
		current.next = new Node<T>(el, current.next);
		if(current.next.next == null) {
			last=current.next;
		}
	}
	public boolean contains(T target) {
		Node<T> current = first;
		while(current!=null) {
			if(current.element.equals(target)) {
				return true;
			}
			else {
				current = current.next;
			}
		}
		return false;
	}
	public void addBefore(T target, T element) {
		if(isEmpty()) {
			return;
		}
		Node<T> current = first;
		int count = 0;
		while(current.element != target) {
			count++;
			current = current.next;
		}
		if(count==0) {
			current = new Node<T>(element, current);
			first = current;
			return;
		}
		current = first;
		for(int i=0; i<count-1; i++) {
			current = current.next;
		}
		current.next = new Node<T>(element, current.next);
	}
	public void addAfter(T target, T element) {
		Node<T> current = first;
		while(current.element != target) {
			current = current.next;
		}
		current.next = new Node<T>(element, current.next);
	}
	public T remove(T target) {
		Node<T> current = first;
		Node<T> previous = null;
		while (current != null && !current.element.equals(target)) {
	        previous = current;
	        current = current.next;
	    }

	    if (current == null) {
	        // target not found
	        return null;
	    } else if (previous == null) {
	        // target found and it's the first node
	        first = first.next;
	    } else {
	        // target found and it's not the first node
	        previous.next = current.next;
	    }

	    return target;
	}
	  public String toString(){
		    String out = "";
		    Node<T> p = first;
		    while(p != null){
		      out += p.element+", ";
		      p = p.next;
		    }
		    return out;
		  }

	public static void main(String []args){
		Linkedlist<String> linked = new Linkedlist<>();
		linked.add("apple");
		linked.add("Orange");
		linked.add(0, "emre");
		linked.add("banana");
		System.out.println(linked.toString());
		System.out.println("There are :: "+linked.size()+" items in the linkedlist");
		System.out.println("The list is empty: " + linked.isEmpty());
		
		//linked.add(1, "emre");
		//System.out.println(linked.toString());
		System.out.println(linked.contains("emre"));
		
		System.out.println(linked.toString());
		linked.addBefore("apple", "hayri");
		System.out.println(linked.toString());
		System.out.println("There are :: "+linked.size()+" items in the linkedlist");
		System.out.println("Before Remove");
		System.out.println("----------------------------");
		System.out.println(linked.remove("apple"));
		System.out.println(linked.remove("emre"));
		System.out.println("-------------------------");
		System.out.println("After Remove");
		System.out.println("There are :: "+linked.size()+" items in the linkedlist");
		System.out.println(linked.toString());
	}

}


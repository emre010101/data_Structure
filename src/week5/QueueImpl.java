package week5;
/*-class definition
 *-instance variables
 *-constructor
 *-isEmpty method
 *-size method
 *-add an element
 *-remove an element
 *-toString method
 * */

public class QueueImpl<T> implements Queue<T> {
	//instance variables
	private QueeNode<T> first;
	private QueeNode<T> last;
	
	public T peek() {
		if(isEmpty()) throw new EmptyQueueException();
		return first.element;
	}
	
	//on the instantiation of the Queue we have no objects in it
	public QueueImpl() {
		first = null;
		last = null;
	}
	public boolean isEmpty() {
		return first==null;
	}
	
	public int size() {
		int count = 0;
		QueeNode<T> current = first;
		while (current != null) {
			if (current == null)
				return count;
			else {
				count++;
				current = current.next;
			}
		}
		return count;
	}
	public void enqueue(T el) {
		if(first==null) {
			first = new QueeNode<T>(el);
			last = first;
		}else {
			last.next = new QueeNode<T>(el);
			last=last.next;
		}	
	}
	public T dequeue() {
		if(isEmpty()) throw new EmptyQueueException();
		QueeNode<T> old=first;
		first=first.next;
		if(isEmpty()) last=null;
		return old.element;
	}
	public String toString() {
		QueeNode<T> itt = first;
		String out = "";
		while(itt!=null) {
			out += itt.element;
			if(itt.next!=null) out+=", ";
			itt=itt.next;
		}
		return out;
	}
	
	public static void main(String[] args) {
		QueueImpl<String> em = new QueueImpl<String>();
		System.out.println(em.isEmpty());
		System.out.println(em.size());
		em.enqueue("emre");
		em.enqueue("kazim");
		em.dequeue();
		em.enqueue("kasar");
		System.out.println(em.toString());
	}
}

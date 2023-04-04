package labs;

	/*
	This is going to be our Node class. We would like our Node class for our
	Single LinkedList to have a data piece and a pointer (reference to the next Node in the list)
*/
public class Node<T>{
	//instance variables
	T element;
	Node<T> next;

	//Constructor
	//We need two constructors
	public Node(T el, Node<T> n){
		element = el;
		next = n;
	}

	// The second constructor is needed when we don't have a Node to point to
	public Node(T el){
		element = el;
		next = null;
	}

	//Methods
	@Override
	public String toString(){
		return "<Element : "+element+" >";
	}

}


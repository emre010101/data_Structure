package labs;
import java.util.*;

public class ArrayStack<T> implements Stack<T> {
	private int maxSize;
	private int top;
	private T[] items;
	
	public ArrayStack(int size) {
		this.maxSize = size;
		this.top = -1;
		this.items = (T[])new Object[maxSize];
	}
	
	public void push(T elem) {
		if(top == maxSize-1) {
			throw new IndexOutOfBoundsException();
		}
		else {
			top++;
			items[top] = elem;
		}
	} 
	
	public T pop() {
		if(top==-1) {
			throw new IndexOutOfBoundsException();
		}
		else {
			T elem = items[top];
			top--;
			return elem;
		}
	}
	
	public String toString() {
		String str = "TOP";
		int counter =top;
		while(counter>=0) {
			str += "\n"+items[counter];
			counter--;
		}
		return str+"\nBOTTOM";
	}
	
	@SuppressWarnings("unused")
	private void reallocate() {
		maxSize*=2;
		items = Arrays.copyOf(items, maxSize);
	}
	
	public static void main (String args []) {
		ArrayStack<Integer> myStack = new ArrayStack<>(100);
		myStack.push(10);
		myStack.push(45);
		
		System.out.println(myStack.toString());
	}

}

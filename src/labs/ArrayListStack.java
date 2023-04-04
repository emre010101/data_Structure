package labs;
import java.util.Arrays;

public class ArrayListStack<T> implements Stack<T> {   
	private int maxSize;								
	private int top;
	private T[] items;


	public ArrayListStack() {
		this.maxSize = 1;
		this.top = -1;
		this.items = (T[])new Object[maxSize];
	}
	
	public void  reallocate() {
		maxSize*=2;
		items = Arrays.copyOf(items, maxSize);
	}
	
	public void push(T elem) {
		if(top == maxSize-1) {
			reallocate();
		}
		top++;
		items[top] = elem;
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
		while(counter>=0){
			str += "\n"+items[counter];
			counter--;
		}
		return str+="\nBOTTOM";
	}

	/*public String validator(T ) {
		String val = toString();
		System.out.println("mfkdmf");
		int match= 0;
		int unmatch =0;
		for(int i=0; i<val.length(); i=+2) {
			if(val.charAt(i)=='>') {
				if(val.charAt(i+1)=='<') {
					match++;
				}
				else if(val.charAt(i+1)=='>') {
					unmatch++;
				}
			}
		}
		return "Matched tags: "+match+" Unmatched tags: "+ unmatch;
	}*/
	public int getSize() {
		return top+1;
	}
	public static void main (String args []) {
		ArrayListStack<String> stacklist = new ArrayListStack<>();
		stacklist.push("emre");
		stacklist.push("neler");
		stacklist.push("oluyor");
		stacklist.push("hayatta");
		stacklist.push("deleted");
		stacklist.push("deleted2");
		stacklist.push("deleted");
		stacklist.push("deleted");
		stacklist.push("deleted");
		stacklist.pop();
		System.out.println(stacklist.toString());
		System.out.println(stacklist.getSize());
	}
	
}


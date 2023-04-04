package labs;
import java.io.*;
/*import java.util.Arrays;
import java.util.regex.*;*/
import java.util.*;
import java.util.regex.Pattern;

public class HTMLstack<T> {
	private int maxSize;
	private int top;
	private T[] items;
	
	public HTMLstack() {
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
		String str = "";
		int counter =top;
		while(counter>=0){
			str += "\n"+items[counter];
			counter--;
		}
		return str;
	}
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	public T peek() {
		if(top==-1) {throw new IndexOutOfBoundsException();}
		return items[top];
	}
	public static void validJava(String s) throws FileNotFoundException {
		File file = new File(s);
		BufferedReader brc= new BufferedReader(new FileReader(file));
		HTMLstack<Character> HTMLval = new HTMLstack<>();
		String st;
		int linenum = 1;
		try {
			while((st=brc.readLine()) != null) {
				for(int i=0; i<st.length(); i++) {
					char c = st.charAt(i);
					if(c=='{') {
						HTMLval.push(c);
					}
					else if(c=='}') {
						if(!HTMLval.isEmpty() && HTMLval.peek()=='{' ) {
						HTMLval.pop();
						}
						else {
							System.out.println("Invalid bracket in line number: "+ linenum);
						}
					}
				}
				linenum++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(HTMLval.isEmpty()) {
			System.out.println("No error of brackets");
		}else {
			System.out.println("There is extra opening brackets in the code");
		}
	}
	public static void validHTML(String s) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(s));
		HTMLstack<Character> HTMLval = new HTMLstack<>();
	
			while(sc.hasNext()) {
				String ss= sc.next();
				for(int i=0; i<ss.length(); i++) {
					char c = ss.charAt(i);
					if(c=='<') {
						//if(Pattern.matches(s, ss))
						HTMLval.push(c);
					}
					else if(c=='}') {
						if(!HTMLval.isEmpty() && HTMLval.peek()=='{' ) {
						HTMLval.pop();
						}
						else {
							System.out.println("The invalid order");
						}
					}
				}
			}
		System.out.print(HTMLval.toString());
	}



	
	public static void main(String args []) throws Exception {
	
		validJava("C:\\Code\\text1.txt");
		//validHTML("C:\\Code\\text1.txt");
	}
}


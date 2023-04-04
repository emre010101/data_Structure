package week5;

public class QueueArrayImpl<T> implements Queue<T> {
	private T[] data;
	private int f=0;
	private int sz=0;
	
	public QueueArrayImpl(int capacity) {
		this.data = (T[]) new Object[capacity];
	}

	public boolean isEmpty() { 
		return sz==0;
	}
	
	public int size() {
		return sz;
	}
	
	public void enqueue(T elem) {
		if(sz==data.length) throw new IllegalStateException("Stack is full");
		int avail = (f+sz)%data.length;
		data[avail]= elem;
		sz++;
	}
	public T peek() {
		if(isEmpty()) return null;
		return data[f];
	}
	
	public T dequeue() {
		if(isEmpty()) throw new EmptyQueueException();
		T ansver = data[f];
		data[f]=null;
		f= (f+1)%data.length;
		sz--;
		return ansver;
	}
	
	public String toString() {
		String out = "";
		int po = f;
		for(int i=0; i<sz; i++) {
			po = po%data.length;
			out = out + data[po];
			//System.out.println(po);
			if(data[po]!=null) {out+=", ";}
			po++;
		}
		return out;
	}

	public static void main(String[] args) {
		QueueArrayImpl<String> hdcs = new QueueArrayImpl<String>(50);
		hdcs.enqueue("emre");
		hdcs.enqueue("alex");
		hdcs.enqueue("can");
		hdcs.enqueue("tanury");
		hdcs.enqueue("isabel");
		hdcs.enqueue("mehmet");
		hdcs.dequeue();
		hdcs.dequeue();
		//System.out.println(hdcs.size());
		System.out.println(hdcs.toString());
	}

}

package Week14;

public class QueueforP {
	
	NodeP first; 
	NodeP last;
	
	public QueueforP() {
		first = null;
		last = null;
	}
	
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int readySize() {
		if(isEmpty()) return 0;
		else {
			return readySize(first);
		}
	}
	
	private int readySize(NodeP current) {
		if(current == null) return 0;
		return 1 + readySize(current.next);
	}


	public void add(NodeP newby) {
		if(isEmpty()) {
			first = newby;
			last =first;
		}else {
			last.next = newby;
			last = last.next;
		}
	}
	
	public int get_averageResponse() {
		if(isEmpty()) return 0;
		int responseTime = 0;
		int preBurst=0;
		NodeP current = first;
		while(current.next != null) {
			preBurst += current.CPUBurstTime;
			current = current.next;
			responseTime += preBurst - current.arrivalTime;
		}
		return responseTime / readySize() ; //
	}
	
	public int get_averageTurnAround() {
		if(isEmpty()) return 0;
		int TurnAround = 0;
		return 1;
	}
	
	
	public void remove() {
		if(isEmpty()) return;
		else {
			first = first.next;
		}
	}
	
	
	public static void main(String[] args) {
		NodeP a1 = new NodeP("shutdown", 0, 5);
		NodeP a2 = new NodeP("open", 3, 8);
		NodeP a3 = new NodeP("open", 4, 2);
		NodeP a4 = new NodeP("open", 6, 7);
		QueueforP myList = new QueueforP();
		myList.add(a1);
		myList.add(a2);
		myList.add(a3);
		myList.add(a4);
		System.out.println(myList.readySize());
		System.out.println("Average:" + myList.get_averageResponse());
	}
}

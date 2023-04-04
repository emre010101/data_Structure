package carRecordsDL;

public class DLlinkedList<T extends CarDetails> {//T extends CarDetails
	NodeDL<T> first, last;
	
	//Have a constructor in order to create linkedlist
	public DLlinkedList() {
		first = null;
		last = null;
	}
	
	public Boolean isEmpty() {
		return first==null;
	}
	
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		NodeDL<T> current = first;
		int count =0;
		while(!(current==null)) {
			current = current.successor;
			count++;
		}
		return count;
	}
	
	public int readySize() {
		if(isEmpty()) {
			return 0;
		}
		NodeDL<T> current = first;
		int count = 0;
		while(!(current==null)) {
			if(current.element.getStatus()==true) {
				count++;
			}
			current = current.successor;
		}
		return count;
	}
	
	public String currentProblems() {
		if(isEmpty()) {
			return "There is no car in the garage";
		}
		NodeDL<T> current = first;
		//Node pre = first;
		String answer = "The cars which are waiting to reparied listed below : "+ "\n";
		while(!(current==null)) {
			if(current.element.getStatus()==false) {
				answer += current.element.toString() + "\n";
			}
			//pre = current;
			current = current.successor;
		}
		//return answer;
		return answer;
	}
	
	public void add(T el) {
		if(isEmpty()) { 
			this.first = new NodeDL<T>(el);
			this.last = this.first;
		}
		else {
			this.last.successor = new NodeDL<T>(el, last.previous);
			last = this.last.successor;
			//last = this.last.n;
		}
	}
	
	public double get_average() {
		double sum = 0;
		NodeDL<T> current = first;
		while(!(current==null)) {
			sum += current.element.getFee();
			current = current.successor;
		}
		double average = sum / size();
		return average;
	}
	
	public void remove(String reg) {
		if(isEmpty()) {
			return;
		}
		NodeDL<T> current = first;
		NodeDL<T> pre = first;
		if(current.element.getRegistration()==reg) {
			first = current.successor;
			if(current.successor==null) {
				first=null;
				first=last;
				return;
			}
			else {
				current.successor.previous = current.successor;
				return;
			}
		}
		while(!(current.element.getRegistration()==reg)) {
			pre = current;
			current = current.successor;
		}
		if(last.element.getRegistration()==reg) {
			pre.successor = null;
			last.previous = null;
		    last = last.previous;
		    return;
		}
		pre.successor = current.successor;
		current.successor.previous = pre;
		return;
	}
	
	public String toString() {
		String cars = "Cars are in the garage listed below: " + "\n";
		NodeDL<T> current = first;
		String status ="";
		for(int i=0; i<size(); i++) {
			status = current.element.getStatus() == true 
					  ? "The car is ready for collection" 
					  : "The car is waiting to be repaired";
			cars += current.element.getRegistration() + "," + current.element.getOwner()+","+current.element.getProblem()+","+current.element.getFee()+","+ current.element.getNumber()+ "," +status + "\n";
			current = current.successor;
		}
		return cars;
	}
	
	public static void main(String args []) {
		DLlinkedList<CarDetails> garage = new DLlinkedList<CarDetails>(); 
		System.out.println(garage.size());
		System.out.println(garage.isEmpty());
		garage.add(new CarDetails("192-AD-58", "emre", "wheels are broken", 958.44, "0892609862", true));
		System.out.println(garage.isEmpty());
		garage.add(new CarDetails("192-45-55", "ahmed", "wheels are broken", 1004.44, "0892609862", false));
		garage.add(new CarDetails("192-BC-55", "hayri", "wheels are broken", 344.66, "0892609862", false));
		garage.add(new CarDetails("192-SS-55", "Paul", "wheels are broken", 2540.50, "0892609862", true));
		System.out.println("The cars in the garage: " + garage.size());
		System.out.println(garage.isEmpty());
		System.out.println(garage.currentProblems());
		System.out.println("To string method: " + garage.toString());
		garage.remove("192-BC-55");
		System.out.println("After removal to string method: " + garage.toString());
		System.out.println("The number of cars available to be collected: " + garage.readySize());
		System.out.println("The average fee of cars to be repeaired in the garage: " + garage.get_average());
		
		System.out.println(garage.currentProblems());
	}
}

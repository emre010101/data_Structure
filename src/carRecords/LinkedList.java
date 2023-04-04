package carRecords;
/*
 * @Emre Kavak
 * 09/02/2023
 * */

public class LinkedList {
	//Declare Nodes which are instance of Node class
	Node first, last;
	
	//Have a constructor in order to create linkedlist
	public LinkedList() {
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
		Node current = first;
		int count =0;
		while(!(current==null)) {
			current = current.n;
			count++;
		}
		return count;
	}
	
	public int readySize() {
		if(isEmpty()) {
			return 0;
		}
		Node current = first;
		int count = 0;
		while(!(current==null)) {
			if(current.c.getStatus()==true) {
				count++;
			}
			current = current.n;
		}
		return count;
	}
	
	public String currentProblems() {
		if(isEmpty()) {
			return "There is no car in the garage";
		}
		Node current = first;
		//Node pre = first;
		String answer = "The cars which are waiting to reparied listed below : "+ "\n";
		while(!(current==null)) {
			if(current.c.getStatus()==false) {
				answer += current.c.toString() + "\n";
			}
			//pre = current;
			current = current.n;
		}
		//return answer;
		return answer;
	}
	
	public void add(CarDetails car) {
		if(isEmpty()) { 
			this.first = new Node(car);
			this.last = this.first;
		}
		else {
			this.last.n = new Node(car);
			last = this.last.n;
		}
	}
	
	public double get_average() {
		double sum = 0;
		Node current = first;
		while(!(current==null)) {
			sum += current.c.getFee();
			current = current.n;
		}
		double average = sum / size();
		return average;
	}
	
	public void remove(String reg) {
		if(isEmpty()) {
			return;
		}
		Node current = first;
		Node pre = first;
		if(current.c.getRegistration()==reg) {
			first = current.n;
		}
		while(!(current.c.getRegistration()==reg)) {
			pre = current;
			current = current.n;
		}
		pre.n = current.n;
		return;
	}
	
	//I confused with another exercise which i have two classes
	public static void main(String args []) {
		LinkedList garage = new LinkedList(); 
		System.out.println(garage.size());
		System.out.println(garage.isEmpty());
		garage.add(new CarDetails("192-AD-58", "emre", "wheels are broken", 958.44, "0892609862", true));
		garage.add(new CarDetails("192-45-55", "ahmed", "wheels are broken", 1004.44, "0892609862", false));
		garage.add(new CarDetails("192-BC-55", "hayri", "wheels are broken", 344.66, "0892609862", false));
		garage.add(new CarDetails("192-SS-55", "Paul", "wheels are broken", 2540.50, "0892609862", true));
		System.out.println("The cars in the garage: " + garage.size());
		System.out.println(garage.isEmpty());
		System.out.println(garage.currentProblems());
		System.out.println("The number of cars available to be collected: " + garage.readySize());
		System.out.println("The average fee of car repeair in the garage: " + garage.get_average());
		System.out.println("remove test");
		System.out.println(garage.currentProblems());
		garage.remove("192-45-55");
		System.out.println(garage.currentProblems());
		//String registration, String owner, String problem, Double fee, String number, Boolean status
	}
}

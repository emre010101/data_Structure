package carRecords;
/*
 * @Emre Kavak
 * 09/02/2023
 * */

public class Node {
	//Declare Variables
	CarDetails c;
	Node n;
	
	public Node(CarDetails car, Node node) {
		this.c = car;
		this.n = node;
	}
	
	public Node(CarDetails car) {
		this.c = car;
		this.n = null;
	}

	@Override
	public String toString() {
		return "Node [c=" + c + ", n=" + n + "]";
	}
	
	public static void main(String args[]) {
		Node emre = new Node(new CarDetails("192-45-55", "Haluk Levent", "Engine broke", 9854.45, "0892609862", true));
		System.out.println(emre.toString());
		System.out.println(emre.c.getFee());
	}
	
	//tring registration, String owner, String problem, Double fee, Integer number, Boolean status
}

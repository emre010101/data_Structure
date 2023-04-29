package Week14;

public class NodeP {
	
	NodeP next;
	String name;
	int arrivalTime;
	int CPUBurstTime;
	
	public NodeP(String n, int aT, int CPT) {
		this.name = n;
		this.arrivalTime = aT;
		this.CPUBurstTime = CPT;
		next = null;
	}
	
	public NodeP(String n, int aT, int CPT, NodeP nex) {
		this.name = n;
		this.arrivalTime = aT;
		this.CPUBurstTime = CPT;
		next = nex;
	}

	@Override
	public String toString() {
		return "Name : " + name + "\n"
				+ "Arrival Time: " + arrivalTime + "\n"
				+ "CPU Burst Time: " + CPUBurstTime;
	}
	
	public static void main(String[] args) {
		NodeP first = new NodeP("Start the Show", 0, 5);
		System.out.println(first.toString());
	}
}

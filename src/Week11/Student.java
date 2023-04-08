package Week11;

public class Student implements Comparable<Student>{

	//Declare variables
	String name;
	int age;
	
	//Constructor
	public Student(String nm, int ag) {
		this.name = nm;
		this.age = ag;
	}
	
	
	@Override
	public int compareTo(Student other) {
		if(this.age<other.age) {
			return -1;
		}else if(this.age>other.age) {
			return 1;
		}else {
			return 0;
		}
	}


	@Override
	public String toString() {
		return "Name : " + this.name + ", Age : " + this.age;
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("emre", 26);
		System.out.println(s1.toString());
	}
	
}

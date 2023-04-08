package College;

public class Student implements Comparable<Student> {
	String name;
	Module modules;
	
	public Student(String nm, Module md) {
		this.name = nm;
		this.modules = md;
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*public static void main(String[] args) {
		Student s1 = new Student("emre", )
	}*/
}

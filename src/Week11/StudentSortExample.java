package Week11;

import java.util.*;

public class StudentSortExample {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Carol", 45));
		students.add(new Student("Adam", 25));
		students.add(new Student("Hakki", 12));
		students.add(new Student("Sibel", 38));
		
		for(Student s : students) {
			System.out.println(s);
		}
		
		System.out.println("After Sort : ");
		
		Collections.sort(students);
		
		for(Student s : students) {
			System.out.println(s);
		}
	}
}

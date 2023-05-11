package TABA;
/**
 * 
 * @author Emre Kavak
 * @date 06/05/2023
 * Person.java
 */

public class Person implements Comparable<Person>{
	
	//Declare Variables
	String name;
	String occupation;
	String maritalStatus;
	String sex;
	String address;
	int age;
	
	//Constructor
	public Person(String name, String occupation, String maritalStatus, String sex, String address, int age) {
		super();
		this.name = name;
		this.occupation = occupation;
		this.maritalStatus = maritalStatus;
		this.sex = sex;
		this.address = address;
		this.age = age;
	}
	
	//Name getter method for remove method in BinarySearchTreeImpl
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", occupation=" + occupation + ", maritalStatus=" + maritalStatus + ", sex="
				+ sex + ", address=" + address + ", age=" + age + "]";
	}


	@Override
	public int compareTo(Person o) {
		// if they are in the same age
		if(this.age == o.age) {
			return 0;

		// if the caller person older than the passed person
		}else if(this.age > o.age) {

			return 1;

		// if the parameter person is older than the caller person the method
		}else {

			return -1;
		}
	}



}

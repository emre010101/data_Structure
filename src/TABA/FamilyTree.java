package TABA;

public class FamilyTree extends BinaryTreeImpl<Person> {

	public static void main(String[] args) {
		
		//Creating instance of FamilyTree
		FamilyTree family = new FamilyTree();
		
		System.out.println("Testing if is Empty: " + family.isEmpty());
		
		//Populating the family with Person Objects
		
		family.insert(new Person("Oisin Murphy", "Software Developer", "Single", "Male", "123 Grafton Street, Dublin", 30));
		family.insert(new Person("Sinéad O'Connor", "Doctor", "Married", "Female", "456 St Stephen's Green, Dublin", 45));
		family.insert(new Person("Emir Kavak", "Teacher", "Single", "Male", "789 Istiklal Caddesi, Istanbul", 28));
		family.insert(new Person("Aylin Yilmaz", "Engineer", "Married", "Female", "321 Bagdat Caddesi, Istanbul", 35));
		family.insert(new Person("Cillian O'Reilly", "Accountant", "Single", "Male", "654 Temple Bar, Dublin", 40));
		family.insert(new Person("Ebru Karaca", "Architect", "Single", "Female", "987 Nisantasi, Istanbul", 32));
		family.insert(new Person("Roisin Kelly", "Nurse", "Married", "Female", "213 Merrion Square, Dublin", 38));
		family.insert(new Person("Mert Demir", "Chef", "Single", "Male", "567 Galata, Istanbul", 29));
		family.insert(new Person("Seamus O'Donnell", "Lawyer", "Married", "Male", "900 Phoenix Park, Dublin", 50));
		family.insert(new Person("Asli Aksoy", "Dentist", "Single", "Female", "333 Kadikoy, Istanbul", 27));

		System.out.println("Testing if is Empty: " + family.isEmpty());
		System.out.println("Size should be 10: " + family.size());
		System.out.println("The oldest should be 'Seamus': " + family.findOldest());
		System.out.println("The youngest should be 'Asli': " + family.findYoungest());
		System.out.println("Gender percentage");
		
		family.inOrder();
		System.out.println(family.genderPercentage());
		family.remove("Asli Aksoy");
		System.out.println("The youngest should be 'Emir' after removing 'Asli' from the tree: " + family.findYoungest());

		//family.inOrder();
	
		System.out.println(family.genderPercentage());
	}
	

}

package tabaJinnie;


public class TreeGenCompany extends BinarySearchTree<Person> {
  public static void main(String[] args) {
    // Declare the company
    TreeGenCompany company = new TreeGenCompany();

    // Demonstrate functionalities

    // isEmpty() method: before adding people into the tree
   // System.out.println("Is the company empty?(Before Insertion): " + company.isEmpty());
    //System.out.println("-------------------------------------------------");

    // insert(T element) method: Add people into the company tree
    company.insert(new Person("Brad Pitt", "HR", "Managing Director", true, "Male", "123 Main St", 55));
    company.insert(new Person("Angelina Jolie", "Planning", "Assistant Manager", true, "Female", "456 Oak St", 38));
    company.insert(new Person("George Clooney", "Finance", "Chief Manager", true, "Male", "789 Elm St", 45));
    company.insert(new Person("Matt Damon", "Marketing", "Manager", true, "Male", "1010 Pine St", 42));
    company.insert(new Person("Harry Styles", "Marketing", "Associate", false, "Male", "111 Maple St", 28));
    company.insert(new Person("Leonardo DiCaprio", "IT", "Manager", false, "Male", "1212 Oak St", 35));
    company.insert(new Person("Kate Winslet", "IT", "Associate", false, "Female", "1313 Pine St", 30));
    company.insert(new Person("Bradley Cooper", "Sales", "Manager", false, "Male", "1414 Main St", 50));
    company.insert(new Person("Julia Roberts", "Data Science", "Associate", true, "Female", "1515 Elm St", 32));
    company.insert(new Person("Will Smith", "Engineering", "Manager", true, "Male", "1616 Maple St", 47));

    // isEmpty() method: after adding people into the tree
   /* System.out.println("Is the company empty?(After Insertion): " + company.isEmpty());
    System.out.println("-------------------------------------------------");

    // size() method: count the number of people
    System.out.println("How many people are in the company?:  " + company.size());
    System.out.println("-------------------------------------------------");

    // findMax() method: find out the oldest person
    System.out.println("Who is the oldest person? " + company.findMax());
    System.out.println("-------------------------------------------------");

    // findMin() method: find out the youngest person
    System.out.println("Who is the youngest person? " + company.findMin());
    System.out.println("-------------------------------------------------");

    // genderPercentage(String gender) method: calculate the gender ratio
    System.out.println("What is the percentage of women in this company? " + company.genderPercentage("female"));
    System.out.println("What is the percentage of men in this company? " + company.genderPercentage("male"));
    System.out.println("-------------------------------------------------");

    // inOrder() method: before removing 'Angelina Jolie'
    System.out.println(
        "Before removing 'Angelina Jolie', The total number of employees is " + company.size()
            + "\nShow me the company tree from top to bottom!");
   // company.inOrder();
    System.out.println("-------------------------------------------------");*/

    company.removeByName("Angelina Jolie");
    

//     inOrder() method: after removing 'Angelina Jolie'
    System.out.println(
        "After removing 'Angelina Jolie', The total number of employees is " + company.size()
            + "\nShow me the company tree from top to bottom!");
    company.inOrder();
    //System.out.println("-------------------------------------------------");
  }
}

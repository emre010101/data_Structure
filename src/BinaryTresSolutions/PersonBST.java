package BinaryTresSolutions;

/*
    The question is simply asking us to create a PersonBST and to demonstrate that we can add
    person objects into the tree and they go into the tree in order...
*/
public class PersonBST extends BinarySearchTree<Person> {

  public static void main(String [] args){

      PersonBST people = new PersonBST();
      people.insert(new Person("Keith", 21));
      people.insert(new Person("Dominic", 23));
      people.insert(new Person("Joe", 54));
      people.insert(new Person("Louise", 34));
      people.inOrder();
  }
}

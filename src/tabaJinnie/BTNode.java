package tabaJinnie;


public class BTNode<T> {

  // Declare the elemet(T type), left and right nodes
  protected T element;
  protected BTNode<T> left;
  protected BTNode<T> right;

  // Constructor for Node
  public BTNode(T element) {
    this.element = element;
  }

  // toString method for presentation
  @Override
  public String toString() {
    // Declare left value
    String leftVal = (left == null ? "NULL" : left.element.toString());
    // Declare right value
    String rightVal = (right == null ? "NULL" : right.element.toString());
    // present all people, left person and right person
    return "Current Person: " + element + "\nLeft: " + leftVal + "\nRight: " + rightVal;
  }

}

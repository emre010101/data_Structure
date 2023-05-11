package tabaJinnie;


public interface BinaryTree<T extends Comparable<T>> {
  // Check if the tree is empty
  public boolean isEmpty();

  // Add new node into the tree
  public void insert(T element);

  // Count the number of nodes
  public int size();

  // Find the oldest person
  public T findMax();

  // Find the youngest person
  public T findMin();

  // Find the gender percentage
  public double genderPercentage(String gender);

  /*
   * Remove an object based on name.
   * 1. I will utilize a private method named findNode to find out the object
   * 2. I will call remove method after finding parent using findParent method
   */
  public boolean removeByName(String name);

  // Print out a representation of the tree
  public void inOrder();
}

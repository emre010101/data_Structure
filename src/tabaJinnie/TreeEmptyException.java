package tabaJinnie;


public class TreeEmptyException extends RuntimeException {
  public TreeEmptyException() {
    // print out an error messge for the exception
    super("There is no person in the tree.");
  }
}

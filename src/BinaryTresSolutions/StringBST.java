package BinaryTresSolutions;

// Our new StingBST extends from the BinarySearchTree that we have implemented.
public class StringBST extends BinarySearchTree<String> {

//inside main we are creating an intstance of the StringBST and adding some words into the tree.
    public static void main(String[] args) {
        StringBST string = new StringBST();
        string.insert("Hello");
        string.insert("World");
        string.insert("How");  
        string.insert("Are");
        string.insert("You");

        int length  = string.totalLength();
        System.out.println("length = " + length);
        string.printGreaterThan(5);
    }

//We would like to calculate the total length of the collection of words in the tree.
    public int totalLength(){
        return totalLength(root);
    }

    private int totalLength(BTNode<String> current) {
        if (current == null){ // this is the place we need to stop
            return 0;
        } else {
          // the current.element gives us access to the value within the Node.
          // if the element is a string invoking the .length() gives us the number of charactors within the string
            return current.element.length() + totalLength(current.left) + totalLength(current.right);
        }
    }

    public void printGreaterThan(int threshold){
        printGreaterThan(threshold, root);
    }

    private void printGreaterThan(int threshold, BTNode<String> current) {
        if (current == null){
            return;
        }
        printGreaterThan(threshold, current.left);
        if (current.element.length() >= threshold){
            System.out.println("current = " + current.element);
        }
        printGreaterThan(threshold, current.right);

    }
}

package tabaJinnie;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
  // Declare root node
  protected BTNode<T> root;

  // isEmpty(): Check if the tree is empty
  public boolean isEmpty() {
    // if root is null, return true
    return root == null;
  }

  // insert(T element): Add new node into the tree
  public void insert(T element) {
    // If the tree is empty, new node will be root
    if (isEmpty()) {
      root = new BTNode<>(element);
    } else {
      // If the tree is not empty, call insert(T element, BTNode<T> current) method
      insert(element, root);
    }
  }

  // Insert new node after comparing with the root
  private void insert(T element, BTNode<T> current) {
    // If the age is younger (lower number) than the current person
    if (element.compareTo(current.element) == -1) {
      // Add it to the left because it's less than the current one
      if (current.left == null) {
        current.left = new BTNode<>(element);
      } else {
        // Call insert method recursively down(current.left)
        insert(element, current.left);
      }

      // If the age is older (higher number) than the person comparing to
    } else {
      // Add it to the right because it's greater than the current one
      if (current.right == null) {
        current.right = new BTNode<>(element);
      } else {
        // Call insert method recursively down(current.right)
        insert(element, current.right);
      }
    }
  }

  // size(): Count the number of nodes
  public int size() {
    // call size(BTNode<T> current) method and use root to figure out the size
    return size(root);
  }

  // Figure out the size using root
  private int size(BTNode<T> current) {
    if (current == null) {
      // if root is null, size is 0
      return 0;
    } else {
      // if root is not null, count all left and right subtree nodes
      return 1 + size(current.left) + size(current.right);
    }
  }

  // findMax(): Find the oldest person
  public T findMax() {
    if (isEmpty()) {
      // If the tree is empty, throw exception
      throw new TreeEmptyException();
    } else {
      // If the tree is not empty, find the oldest person using root
      return findMax(root);
    }
  }

  // Utilize the fact that oldest person is in the right subtree
  private T findMax(BTNode<T> current) {
    // Base case
    if (current.right == null) {
      // If there's no right node to move to, return the current(at the right end)
      return current.element;
      // Recursive case
    } else {
      // Call the findMax method recursively to move to right continuously
      return findMax(current.right);
    }
  }

  // findMin(): Find the youngest person
  public T findMin() {
    if (isEmpty()) {
      // If the tree is empty, throw exception
      throw new TreeEmptyException();
    } else {
      // If the tree is not empty, find the youngest person using root
      return findMin(root);
    }
  }

  // Utilize the fact that youngest person is in the left subtree
  private T findMin(BTNode<T> current) {
    // Base case
    if (current.left == null) {
      // If there's no left node to move to, return the current(at the left end)
      return current.element;
      // Recursive case
    } else {
      // Call the findMax method recursively to move to left continuously
      return findMin(current.left);
    }
  }

  // genderPercentage(String gender): Find the gender percentage
  public double genderPercentage(String gender) {
    // If the tree is empty, there's no gender percentage
    if (isEmpty()) {
      return 0.0;
    }
    // Count the total number of nodes using size() method
    int totalSize = size(root);

    // Count the number of nodes with the specific gender using genderSize method
    int genderSize = genderSize(root, gender);

    // Calculate the gender percentage based on specific gender
    return (double) genderSize / totalSize * 100;
  }

  // Count the number of nodes with the specific gender
  private int genderSize(BTNode<T> current, String gender) {
    // Declare the count
    int count = 0;

    // Base case
    if (current == null) {
      // If the current node is null, return 0
      return 0;
    }

    // if the current node has the specific gender, increase the count
    if (((Person) current.element).getSex().equalsIgnoreCase(gender)) {
      count = 1;
    }

    // Recursive case: count all left and right subtree nodes if it has given gender
    return count + genderSize(current.left, gender) + genderSize(current.right, gender);
  }

  // removeByName(String name): Remove an object based on the name
  public boolean removeByName(String name) {
    // Find the node with the given name using findNode method
    BTNode<T> toRemove = findNode(name);
    // If the node is not founded, return false
    if (toRemove == null) {
      System.out.println("not found");
      return false;
    }
    // Find the parent of that node
    BTNode<T> parent = findParent(name);
    // Call remove method using toRemove and parent
    return remove(toRemove, parent);
  }

  // Find the minimum value node in the subtree rooted at the given node
  private BTNode<T> findMinNode(BTNode<T> node) {
    if (node.left == null) {
      return node;
    }
    return findMinNode(node.left);
  }

  // Remove a specific node using parent
  private boolean remove(BTNode<T> toRemove, BTNode<T> parent) {
    // If is's null, return false
    if (toRemove == null) {
      System.out.println("not found");
      return false;
    }
    // Print out the node and its parent
    System.out.println("toRemove = " + toRemove);
    System.out.println("parent = " + parent);

    // If that node has no children,
    if (toRemove.left == null && toRemove.right == null) {
      // Find out if the node to remove is the left or right child of its parent
      if (toRemove == parent.left) {
        parent.left = null;
      } else {
        parent.right = null;
      }
      return true;

      // If that node has left child only,
    } else if (toRemove.left != null && toRemove.right == null) {
      // Find out if the node to remove is the left or right child of its parent
      if (toRemove == parent.left) {
        // Replace the node to remove with its left child
        parent.left = toRemove.left;
      } else {
        // Replace the node to remove with its left child
        parent.right = toRemove.left;
      }
      return true;

      // If that node has right child only,
    } else if (toRemove.left == null && toRemove.right != null) {
      // Find out if the node to remove is the left or right child of its parent
      if (toRemove == parent.left) {
        // Replace the node to remove with its right child
        parent.left = toRemove.right;
      } else {
        // Replace the node to remove with its right child
        parent.right = toRemove.right;
      }
      return true;

      // If that node has left and right children,
    } else if (toRemove.left != null && toRemove.right != null) {
      // Find out the minimum value node among right subtree objects
      BTNode<T> minValueNode = findMinNode(toRemove.right);

      // If the minimum value node is not found, return false
      if (minValueNode == null) {
        return false;
      }

      // Find out the replacement node and its parent using the name of the minimum
      // value node
      BTNode<T> replacement = findNode(((Person) minValueNode.element).getName());
      BTNode<T> replacementParent = findParent(((Person) minValueNode.element).getName());
      System.out.println("replacementParent = " + replacementParent);

      // Remove the replacement node from the parent if the replacementParent is not
      // null and the replacement node is not the direct right child of the node to be
      // removed
      if (replacementParent != null && replacement != toRemove.right) {
        if (replacementParent.left == replacement) {
          replacementParent.left = replacement.right;
        } else {
          replacementParent.right = replacement.right;
        }
      }

      if (replacement != null) {
        // Replace the removed node's element with the replacement's element
        toRemove.element = replacement.element;
        // If the replacement node is the direct right child of the node to be removed,
        // update the removed node's right child
        if (replacement == toRemove.right) {
          toRemove.right = replacement.right;
        }
        return true;
      } else {
        return false;
      }
    }
    // Print out its parent
    System.out.println("parent = " + parent);
    return false;
  }

//Find the node based on the given name
private BTNode<T> findNode(String name) {
 // Search for the node from the root
 return findNode(name, root);
}

//Find the node based on the given name starting from the current node
private BTNode<T> findNode(String name, BTNode<T> current) {
 // If the current node is null, return null
 if (current == null) {
   return null;
 }

 // Get the person name of the current node
 String currentName = ((Person) current.element).getName();

 // Check if the current node has the given name
 if (currentName.equals(name)) {
   return current;
 }

 // Recursively search in the left subtree
 BTNode<T> leftResult = findNode(name, current.left);
 if (leftResult != null) {
   return leftResult;
 }

 // Recursively search in the right subtree
 return findNode(name, current.right);
}

private BTNode<T> findParent(String name) {
 // Call the recursive findParent method
 return findParent(name, root, null);
}

//Add an extra parameter to the method to keep track of the parent
private BTNode<T> findParent(String name, BTNode<T> current, BTNode<T> parent) {
 if (current == null) {
   return null;
 }

 String currentName = ((Person) current.element).getName();

 if (currentName.equals(name)) {
   // Return the parent instead of null when the node is found
   return parent;
 }

 // Recursively search in the left subtree
 BTNode<T> leftResult = findParent(name, current.left, current);
 if (leftResult != null) {
   return leftResult;
 }

 // Recursively search in the right subtree
 return findParent(name, current.right, current);
}

  // inOrder(): Print out a representation of the tree
  public void inOrder() {
    // Call inOrder method based on root
    inOrder(root);
  }

  // Return all nodes based on the inOrder sequence
  private void inOrder(BTNode<T> current) {
    // If there's no object in the tree, return nothing
    if (current == null) {
      return;
    }
    // If there are objects in the tree, return them
    // Ther sequence is 'right node -> current node -> left node'
    inOrder(current.right);
    System.out.println(current);
    inOrder(current.left);
  }
  

}

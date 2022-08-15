

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree < E >
    implements Serializable {

  /** Class to encapsulate a tree node. */
  protected static class Node < E >
      implements Serializable {
    // Data Fields
    /** The information stored in this node. */
    protected E data;
    
    protected Node<E> parent;
    /** Reference to the left child. */
    protected Node < E > left;

    /** Reference to the right child. */
    protected Node < E > right;

    // Constructors
    /** Construct a node with given data and no children.
        @param data The data to store in this node
     */
    public Node(E data) {
      this.data = data;
      left = null;
      right = null;
      parent = null;
    }

    // Methods
    /** Return a string representation of the node.
    	@return A string representation of the data fields
     */
	public String toString() {
	  return data.toString();
	}
    /** Return a string representation of the node.
        @return A string representation of the data fields
     */
    public String toString(Node < Integer > root) {
        StringBuilder builder = new StringBuilder();
        if (root == null)
            return "";
        builder.append(toString(root.left));
        builder.append(toString(root.right));
        return builder.append(root.data.toString()).toString();
    }
	public Node<E> getLeftNode(){
		return this.left;
	}
	public Node<E> getLeftRightNode(){
		return this.right;
	}
  }

  // Data Field
  /** The root of the binary tree */
  protected Node < E > root;

  public BinaryTree() {
    root = null;
  }

  protected BinaryTree(Node < E > root) {
    this.root = root;
  }

  /** Constructs a new binary tree with data in its root,leftTree
      as its left subtree and rightTree as its right subtree.
   */
  public BinaryTree(E data, BinaryTree < E > leftTree,
                    BinaryTree < E > rightTree) {
    root = new Node < E > (data);
    if (leftTree != null) {
      root.left = leftTree.root;
    }
    else {
      root.left = null;
    }
    if (rightTree != null) {
      root.right = rightTree.root;
    }
    else {
      root.right = null;
    }
  }
  /**
   * TreeITerator is an iterator that helps to traverse the tree inorder way.*/
  public class TreeIterator<E> {
	    private Node<E> next;

	   /**
	    * Constructor
	    * At First goes to left
	    * */
	    public TreeIterator() {
	        next = (Node<E>) root;
	        if(next == null)
	            return;

	        while (next.left != null)
	           next = next.left;
	    }
	    /**
	     * Constructor
	     * */
	    public TreeIterator(Node<E> root) {
	        next = root;
	        if(next == null)
	            return;

	        while (next.left != null)
	           next = next.left;
	    }
	    /**
	     * if it has next or not
	     * @return true if has*/
	    public boolean hasNext(){
	        return next != null;
	    }
	    /**
	     * Goes to next node according to the inorder traverse rule
	     * O(N)
	     * */
	    public Node<E> next(){
	        if(!hasNext()) throw new NoSuchElementException();
	        Node<E> r = next;

	        if(next.right != null) {
	            next = next.right;
	            while (next.left != null)
	                next = next.left;
	            return r;
	        }

	        while(true) {
	            if(next.parent == null) {
	                next = null;
	                return r;
	            }
	            if(next.parent.left == next) {
	                next = next.parent;
	               return r;
	            }
	            next = next.parent;
	        }
	     }
	 }
  


  /** Return the left subtree.
      @return The left subtree or null if either the root or
      the left subtree is null
   */
  public BinaryTree < E > getLeftSubtree() {
    if (root != null && root.left != null) {
      return new BinaryTree < E > (root.left);
    }
    else {
      return null;
    }
  }

  /** Return the right sub-tree
        @return the right sub-tree or
        null if either the root or the
        right subtree is null.
    */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        } else {
            return null;
        }
    }

  /**** BEGIN EXERCISE ****/
  /** Return the data field of the root
        @return the data field of the root
        or null if the root is null
    */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }
  /**** END EXERCISE ****/

  /** Determine whether this tree is a leaf.
      @return true if the root has no children
   */
  public boolean isLeaf() {
    return (root.left == null && root.right == null);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrderTraverse(root, 1, sb);
    return sb.toString();
  }

  /** Perform a preorder traversal.
      @param node The local root
      @param depth The depth
      @param sb The string buffer to save the output
   */
  private void preOrderTraverse(Node < E > node, int depth,
                                StringBuilder sb) {
    for (int i = 1; i < depth; i++) {
      sb.append("  ");
    }
    if (node == null) {
      sb.append("null\n");
    }
    else {
      sb.append(node.toString());
      sb.append("\n");
      preOrderTraverse(node.left, depth + 1, sb);
      preOrderTraverse(node.right, depth + 1, sb);
    }
  }

  /** Method to read a binary tree.
      pre: The input consists of a preorder traversal
           of the binary tree. The line "null" indicates a null tree.
      @param bR The input file
      @return The binary tree
      @throws IOException If there is an input error
   */
  public static BinaryTree < String >
      readBinaryTree(BufferedReader bR) throws IOException {
    // Read a line and trim leading and trailing spaces.
    String data = bR.readLine().trim();
    if (data.equals("null")) {
      return null;
    }
    else {
      BinaryTree < String > leftTree = readBinaryTree(bR);
      BinaryTree < String > rightTree = readBinaryTree(bR);
      return new BinaryTree < String > (data, leftTree, rightTree);
    }
  }



}

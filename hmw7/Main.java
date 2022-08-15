import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static <T> void main(String[] args) throws Exception {

        TestQ1();
        TestQ2();
    }


    /**
     * Question 1 test method. Just run this*/
    public static void TestQ1() {
        Integer[] arr = new Integer[9];
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();

        bTree.root = new BinaryTree.Node<Integer>(1);
        bTree.root.parent = null;

        bTree.root.left = new BinaryTree.Node<Integer>(7);
        bTree.root.left.parent = bTree.root;

        bTree.root.left.left = new BinaryTree.Node<Integer>(2);
        bTree.root.left.left.parent = bTree.root.left;

        bTree.root.left.right = new BinaryTree.Node<Integer>(6);
        bTree.root.left.right.parent = bTree.root.left;

        bTree.root.left.right.left = new BinaryTree.Node<Integer>(5);
        bTree.root.left.right.left.parent = bTree.root.left.right;

        bTree.root.left.right.right = new BinaryTree.Node<Integer>(11);
        bTree.root.left.right.right.parent = bTree.root.left.right;

        bTree.root.right = new BinaryTree.Node<Integer>(9);
        bTree.root.right.parent = bTree.root;

        bTree.root.right.right = new BinaryTree.Node<Integer>(9);
        bTree.root.right.right.parent = bTree.root.right;

        bTree.root.right.right.left = new BinaryTree.Node<Integer>(5);
        bTree.root.right.right.left.parent = bTree.root.right.right;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }
        System.out.println("Before:");
        System.out.println("\n"+bTree.toString());
        System.out.println("-------------------------");
        System.out.println("After:\n");
        bTree = Q1(bTree,arr);
        System.out.println("\n"+bTree.toString());

    }

    /**
     * first, the given array will be sorted after that the traverse will be carried out on
     * given binaryTree inorder way and one by one, at each node, the given array's elements will be put
     * binary tree.
     * @param bt BinarTree<T> generic binary tree. must be comparable
     * @param items T[] generic array. must be comparable
     * @return binarySearch tree*/
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T extends Comparable<T>> BinaryTree<T> Q1(BinaryTree<T> bt, T[] items) {
        //BinarySearchTree<T> bst = new BinarySearchTree<T>();

        System.out.print("Given arr: [");
        for(int i=0; i<items.length; ++i) System.out.print(items[i]+" ");
        System.out.println("] ");

        BinaryTree.TreeIterator it2 = bt.new TreeIterator<T>();
        System.out.print("Given bt (inorder way): ");
        while(it2.hasNext()) System.out.print(it2.next().data+" "); //Theta(N)
        System.out.println();

        //1-    Sort given items array
        Arrays.sort(items); //quick sort

        //2-    Traverse Given Binary Tree in inorder way and
        //       Put Sorted Arrays elements one by one to the binary Tree
        BinaryTree.TreeIterator it = bt.new TreeIterator<T>();
        int i=0;
        while(it.hasNext()) {
            it.next().data = items[i];
            i++;
        }

        //print
        System.out.println();
        System.out.print("After Operation (inorder way): ");
        it2 = bt.new TreeIterator<T>();
        while(it2.hasNext()) System.out.print(it2.next().data+" "); //O (n^2)

        return bt;
    }
    /*-------------------------------------------------------------------------------------*/
    /**
     * Q2 driver method. Just call this function to test*/
    public static void TestQ2() {
        //create binary Tree:
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.add(40);
        bst.add(30);
        bst.add(50);
        bst.add(20);
        bst.add(35);
        bst.add(45);
        bst.add(60);
        bst.add(70);
        bst.add(41);
        bst.add(46);
        bst.add(42);
        System.out.println("Before: ");
        System.out.println(bst.toString());
        System.out.println("\n----------------------------------\n");
        
        System.out.println("After: ");
        bst = Q2(bst);
        System.out.println(bst.toString());
        

    }
    /**
     * Q2 method that balances*/
    public static <T extends Comparable<T>> BinarySearchTree<T> Q2(BinarySearchTree<T> bst1) {
        balance(bst1, bst1);
        return bst1;
    }
    /**
     * Balances the given binary search tree - O(nlogn)
     * @param bst1 binary search tree that will changed
     * @param bst2 different reference for bst1
     * */
    public static <T extends Comparable<T>> void balance(BinarySearchTree<T> bst1, BinarySearchTree<T> bst2) {

        if (bst1 == null)
            return;
        
        T rootVal = bst1.root.data;
        balance(bst1.getLeftSubtree(), bst2);
        balance(bst1.getRightSubtree(), bst2);

        int balance = getBalance(bst1.root);

        Integer[] arr = new Integer[1];
        // LL
        if (balance > 1 && getBalance(bst1.root.left) >= 0) {
            int temp = (int)(Object)bst1.root.data; 
            bst1.root = rightRotate(bst1.root);
            if (!rootVal.equals(temp)) {
                findParent(bst2.root, (int) temp, -1, arr);
                if(bst2.find(arr[0]).data.compareTo(bst1.root.data) < 0)
                    bst2.find(arr[0]).right = bst1.root; 
                else
                    bst2.find(arr[0]).left = bst1.root; 
            }
        }       

        // RR
        if (balance < -1 && getBalance(bst1.root.right) <= 0) {
        	int temp = (int)(Object)bst1.root.data; 
            bst1.root = leftRotate(bst1.root);
            if(!rootVal.equals(temp)){
                findParent(bst2.root, (int) temp, -1, arr);
                if (bst2.find(arr[0]).data.compareTo(bst1.root.data) < 0)
                    bst2.find(arr[0]).right = bst1.root; 
                else
                    bst2.find(arr[0]).left = bst1.root; 
            }
        }

         // LR
        if (balance > 1 && getBalance(bst1.root.left) == -1) {
        	int temp = (int)(Object)bst1.root.data; 
            bst1.root.left = leftRotate(bst1.root.left);
            bst1.root = rightRotate(bst1.root);
            if(!rootVal.equals(temp)){
                findParent(bst2.root, (int) temp, -1, arr);
                if (bst2.find(arr[0]).data.compareTo(bst1.root.data) < 0)
                    bst2.find(arr[0]).right = bst1.root;
                else
                    bst2.find(arr[0]).left = bst1.root;
            }
        }

        // RL
        if (balance < -1 && getBalance(bst1.root.right) == 1) {
        	int temp = (int)(Object)bst1.root.data; 
            bst1.root.right = rightRotate(bst1.root.right);
            bst1.root = leftRotate(bst1.root);
            if(!rootVal.equals(temp)){
                findParent(bst2.root, (int)temp, -1, arr);
                if (bst2.find(arr[0]).data.compareTo(bst1.root.data) < 0)
                    bst2.find(arr[0]).right = bst1.root;
                else  bst2.find(arr[0]).left = bst1.root;
            }

        }
   
    }
    /**
     * finds parent's value of given binary tree - O(N)
     * @param root root of the tree
     * @param val value of the parent that will be found
     * @param parent value of parent
     * @param result parent's value
     * */
    public static <T extends Comparable<T>> void findParent( BinaryTree.Node<T> root, int val, int parent, Integer[] result) {
        if (root == null)
            return;        
        if (root.data.equals(val)) {
            result[0] = parent;
        } else {
            int temp = (int)(Object)root.data; 
            findParent(root.left, val, temp, result);
            findParent(root.right, val, temp, result);
        }
    }
    /**
     * Carried Out right balancing Theta(1)
     * @param root the root
     * @return new root*/
    public static <T extends Comparable<T>> BinarySearchTree.Node<T> rightRotate(BinarySearchTree.Node<T> root) {

        BinarySearchTree.Node<T> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    /**
     * Carried Out left balancing Theta(1)
     * @param root the root
     * @return new root*/
    public static <T extends Comparable<T>> BinarySearchTree.Node<T> leftRotate(BinarySearchTree.Node<T> root) {

        BinarySearchTree.Node<T> newRoot = root.right; 
        root.right = newRoot.left; 
        newRoot.left = root;
        return newRoot;
    }

    /**
     * Returns Height of the given node Theta(1)
     * @param node node
     * @return height of the given node*/
    public static <T extends Comparable<T>> int getHeight(BinarySearchTree.Node<T> node) {
        if (node == null)
            return -1;
        if (isLeaf(node))
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * Returns balance value of the given node Theta(1)
     * @param node node
     * @return height of the given node*/
    public static <T extends Comparable<T>> int getBalance(BinarySearchTree.Node<T> node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * Returns if given node is leaf or not Theta(1)
     * @param node node
     * @return height of the given node*/
    public static <T extends Comparable<T>> boolean isLeaf(BinarySearchTree.Node<T> node) {
        return (node.left == null && node.right == null);
    }



}
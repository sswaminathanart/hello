package tree;

import java.util.ArrayList;
import java.util.List;

class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}
public class AVLTree {
    Node root;

    // A utility function to get the height of the tree
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }
    // Get Balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int key) {

        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));

        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
        List<Integer> result = new ArrayList<>();
        result.toArray(new Integer[result.size()]);
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
    }


}
/*
import java.io.*;
import java.util.*;

public class AVLTree {
    public class Node {
        private Node left, right, parent;
        private int height = 1;
        private int value;

        private Node (int val) {
            this.value = val;
        }
    }
    private int height (Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
                return(new Node(value));
                }

                if (value < node.value)
        node.left  = insert(node.left, value);
        else
        node.right = insert(node.right, value);

        node.height = Math.max(height(node.left), height(node.right)) + 1;


        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && value < node.left.value)
        return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.value)
        return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.value)
        {
        node.left =  leftRotate(node.left);
        return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value)
        {
        node.right = rightRotate(node.right);
        return leftRotate(node);
        }

        return node;
        }

private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right))+1;
        x.height = Math.max(height(x.left), height(x.right))+1;

        // Return new root
        return x;
        }

private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;

        // Return new root
        return y;
        }

// Get Balance factor of node N
private int getBalance(Node N) {
        if (N == null)
        return 0;
        return height(N.left) - height(N.right);
        }

public void preOrder(Node root) {
        if (root != null) {
        preOrder(root.left);
        System.out.printf("%d ", root.value);
        preOrder(root.right);
        }
        }

private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
        current = current.left;
        return current;
        }

private Node deleteNode(Node root, int value) {
        // STEP 1: PERFORM STANDARD BST DELETE

        if (root == null)
        return root;

        // If the value to be deleted is smaller than the root's value,
        // then it lies in left subtree
        if ( value < root.value )
        root.left = deleteNode(root.left, value);

        // If the value to be deleted is greater than the root's value,
        // then it lies in right subtree
        else if( value > root.value )
        root.right = deleteNode(root.right, value);

        // if value is same as root's value, then This is the node
        // to be deleted
        else {
        // node with only one child or no child
        if( (root.left == null) || (root.right == null) ) {

        Node temp;
        if (root.left != null)
        temp = root.left;
        else
        temp = root.right;

        // No child case
        if(temp == null) {
        temp = root;
        root = null;
        }
        else // One child case
        root = temp; // Copy the contents of the non-empty child

        temp = null;
        }
        else {
        // node with two children: Get the inorder successor (smallest
        // in the right subtree)
        Node temp = minValueNode(root.right);

        // Copy the inorder successor's data to this node
        root.value = temp.value;

        // Delete the inorder successor
        root.right = deleteNode(root.right, temp.value);
        }
        }

        // If the tree had only one node then return
        if (root == null)
        return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
        return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
        root.left =  leftRotate(root.left);
        return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
        return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
        }

        return root;
        }

public void print(Node root) {

        if(root == null) {
        System.out.println("(XXXXXX)");
        return;
        }

        int height = root.height,
        width = (int)Math.pow(2, height-1);

        // Preparing variables for loop.
        List<Node> current = new ArrayList<Node>(1),
        next = new ArrayList<Node>(2);
        current.add(root);

final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength*width);
        for(int i = 0; i < maxHalfLength*width; i++)
        sb.append(' ');
        String textBuffer;

        // Iterating through height levels.
        for(int i = 0; i < height; i++) {

        sb.setLength(maxHalfLength * ((int)Math.pow(2, height-1-i) - 1));

        // Creating spacer space indicator.
        textBuffer = sb.toString();

        // Print tree node elements
        for(Node n : current) {

        System.out.print(textBuffer);

        if(n == null) {

        System.out.print("        ");
        next.add(null);
        next.add(null);

        } else {

        System.out.printf("(%6d)", n.value);
        next.add(n.left);
        next.add(n.right);

        }

        System.out.print(textBuffer);

        }

        System.out.println();
        // Print tree node extensions for next level.
        if(i < height - 1) {

        for(Node n : current) {

        System.out.print(textBuffer);

        if(n == null)
        System.out.print("        ");
        else
        System.out.printf("%s      %s",
        n.left == null ? " " : "/", n.right == null ? " " : "\\");

        System.out.print(textBuffer);

        }

        System.out.println();

        }

        // Renewing indicators for next run.
        elements *= 2;
        current = next;
        next = new ArrayList<Node>(elements);

        }

        }

public static void main(String args[]) {
        AVLTree t = new AVLTree();
        Node root = null;
        while (true) {
        System.out.println("(1) Insert");
        System.out.println("(2) Delete");

        try {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferRead.readLine();

        if (Integer.parseInt(s) == 1) {
        System.out.print("Value to be inserted: ");
        root = t.insert(root, Integer.parseInt(bufferRead.readLine()));
        }
        else if (Integer.parseInt(s) == 2) {
        System.out.print("Value to be deleted: ");
        root = t.deleteNode(root, Integer.parseInt(bufferRead.readLine()));
        }
        else {
        System.out.println("Invalid choice, try again!");
        continue;
        }

        t.print(root);
        }
        catch(IOException e) {
        e.printStackTrace();
        }
        }
        }
        }
 */
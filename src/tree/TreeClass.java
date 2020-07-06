package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeClass {
    public static void main(String args[]) {
        Node root = new Node(44);
        root.left = new Node(17);
        root.right = new Node(88);
        root.left.left = new Node(8);
        root.left.right = new Node(32);
        root.left.right.left = new Node(28);
        root.left.right.left.right = new Node(29);
        root.right.left = new Node(65);
        root.right.right = new Node(97);
        root.right.right.left = new Node(93);
        root.right.left.left = new Node(54);
        root.right.left.right = new Node(82);
        root.right.left.right.left = new Node(76);
        root.right.left.right.left.left = new Node(68);
        root.right.left.right.left.right = new Node(80);
        Node n = seaechANodeInBST(root,54);
        System.out.println(n==null ? "null" : n.key);
        n = insertANodeInBST(root,53);
        insertANodeInBST(root,55);
        n = findMni(root);
        DFS(root);
        preOrderBFS(root);
        System.out.println("Min Value " + n.key);
        n = findMax(root);
        System.out.println("Max Value " + n.key);
        n = successor(root, 32);
        System.out.println("Next Max Value of 32 is "+  + n.key);
        root=deleteANode(root,55);
        n = seaechANodeInBST(root,54);
        System.out.println(n==null ? "null" : n.key);
        root=deleteANode(root,53);
        n = seaechANodeInBST(root,54);
        System.out.println(n==null ? "null" : n.key);
        root=deleteANode(root,44);
        n = seaechANodeInBST(root,54);
        System.out.println(n==null ? "null" : n.key);
    }
    static Node seaechANodeInBST(Node root,int key) {
        if(root == null){
            return null;
        }
        Node curr = root;
        while (curr !=null) {
            if(key ==curr.key){
                return curr;
            }
            if(key < curr.key){
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
        return null;
    }
    static Node insertANodeInBST(Node root,int key) {
        Node newNode = new Node(key);
        if(root == null){
            return newNode;
        }
        Node curr = root;
        Node prev = null;
        while (curr !=null) {
            if(key ==curr.key){
                System.out.println("Node already exists");
                return root;
            }
            if(key < curr.key){
                prev = curr;
                curr = curr.left;
            }
            else {
                prev = curr;
                curr = curr.right;
            }
        }
        if (key < prev.key) {
            prev.left = newNode;
            System.out.println("Inserted at left of "+ prev.key);
        }
        else {
            prev.right = newNode;
            System.out.println("Inserted at right of "+ prev.key);
        }
        return null;
    }



    static Node findMni(Node root) {
        if(root == null) {
            return null;
        }
        Node curr = root;
        while (curr.left !=null) {
            curr = curr.left;
        }
        return curr;
    }
    static Node findMax(Node root) {
        if(root == null) {
            return null;
        }
        Node curr = root;
        while (curr.right !=null) {
            curr = curr.right;
        }
        return curr;
    }

    static Node successor(Node root,int key) {
        if(root == null) {
            return null;
        }
        Node p = seaechANodeInBST(root,key);
        if(p.right !=null) {
            Node curr = p.right;
            while (curr !=null) {
                curr = curr.left;
            }
            return curr;
        }
        else {
            Node leastestLeftNode = null;
            Node curr = root;
            while (curr.key != p.key) {
                if(p.key < curr.key) {
                    leastestLeftNode = curr;
                    curr = curr.left;
                }
                else {
                    curr = curr.right;
                }
            }
            return leastestLeftNode;
        }
    }
    //case 1
    static Node deleteANode(Node root, int key) {
        if (root==null) {
            return null;
        }
        Node curr = root;
        Node prev = null;
        while (curr !=null) {
            if  (curr.key == key) break;
            if (key < curr.key) {
                prev = curr;
                curr = curr.left;
            }
            else {
                prev = curr;
                curr = curr.right;
            }
        }

        if(prev ==null && root.key == key) {
            System.out.println("Root node deleted");
            root = null;
           return null;
        }
        else if (curr.right == null && curr.left == null) {
            if(curr == prev.right) {
                System.out.println("Node found in leaf on right side of its parent");
                prev.right=null;
            }
            else if (curr == prev.left) {
                System.out.println("Node found in leaf on left side of its parent");
                prev.left = null;
            }

        }
        return root;
    }

    static void  DFS(Node root) {
        if(root ==null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n =q.poll();
            System.out.println(n.key);
            if(n.left !=null) {
                q.add(n.left);
            }
            if(n.right != null) {
                q.add(n.right);
            }
        }
    }

    static void preOrderBFS(Node root) {
        if(root ==null) {
            return;
        }
        System.out.println(root.key);
        if(root.left !=null) {
            preOrderBFS(root.left);
        }
        //In order System.out.println(root.key);
        if(root.right != null) {
            preOrderBFS(root.right);
        }
        //Post order System.out.println(root.key);
    }

    static class Node {
        int key;
        //int value;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
}
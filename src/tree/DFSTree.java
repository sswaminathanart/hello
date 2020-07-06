package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class DFSTree {
    public static void main(String args[]) {
        int[] x = new int[10];
        Random intran = new Random();
        for(int i=0;i<x.length;i++) {
            x[i] = intran.nextInt(9999);
        }
        for(int i=0;i<x.length;i++) {
            System.out.println(x[i]);
        }
        TreeNode root = null;

        for(int i=0;i<x.length;i++) {
            root =insertInBST(root,x[i]);
        }
        System.out.println("In order BFS");
        bfs(root);

    }
    static void bfs(TreeNode root){
        if(root == null) {
            return;
        }
        bfs(root.left);

        bfs(root.right);
            System.out.println( root.key);
    }
    static void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode c = q.poll();
            System.out.println(c.key);
            if(c.left !=null){
                q.add(c.left);
            }
            if(c.right !=null){
                q.add(c.right);
            }
        }
    }
    static TreeNode insertInBST(TreeNode root,int val) {
        if(root==null) {
            return new TreeNode(val);
        }
        if(val < root.key) {
            root.left = insertInBST(root.left,val);
        }
        else {
            root.right = insertInBST(root.right,val);
        }
        return root;
    }

    static TreeNode deleteInBST(TreeNode root,int val) {
        if(root==null) {
            return null;
        }
                /*
        3 cases
        Case 1 Node to be deleted has both children(left and right)
        we need successor or prediccessor to replace that node Let us take successor
            Case 1.1 (Successor and successor parent are there)
            Case 1.2 (Successor is there and successor parent is not there there)
        Case 2 Node to be deleted has only ono child
        Caes 3 Node to be deleted has no child(leaf node)
        */
        if(root.key == val) {
            //case 1
            if(root.left != null && root.right != null) {
                TreeNode successorParent = null;
                TreeNode successor = root.right;
                while(successor.left != null) {
                    successorParent = successor;
                    successor =successor.left;
                }
                //Case 1.1 (Successor and successor parent are there)
                if(successorParent != null) {
                    successorParent.left = successor.right;
                }
                else {//Case 1.2 (Successor is there and successor parent is not there there)
                    root.right =  successor.right;
                }
                root.key = successor.key;
                return root;
            }
            //case 2
            else if(root.left != null) {
                return root.left;
            }
            //case 2
            else if(root.right != null) {
                return root.right;
            }
            //case 3
            return null;
        }
        //recursive code
        if(val < root.key) {
            root.left = deleteInBST(root.left,val);
        }
        else {
            root.right = deleteInBST(root.right,val);
        }
        return root;
    }
    static class TreeNode {
        int key;
        //int value;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }
}

package tree;

import java.util.Random;

public class IsBST {
    public static void main(String args[]) {
        int[] x = new int[10];
        Random intran = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = intran.nextInt(9999);
        }
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
        TreeNode root = null;
        for (int i = 0; i < x.length; i++) {
            root =insertInBST(root, x[i]);
        }
        boolean b= isBFS(root);
        if(b) {
            System.out.println("Tree is BST");
        }

    }
    static boolean isBFS(TreeNode root) {
        return isBFS(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static boolean isBFS(TreeNode node,int min,int max) {
        return node==null ||(min<=node.key && node.key <= max && isBFS(node.left,min,node.key) && isBFS(node.right,node.key,max));
    }
    static TreeNode insertInBST(TreeNode root, int val) {
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

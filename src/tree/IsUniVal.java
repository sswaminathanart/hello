package tree;

public class IsUniVal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            left = null;
            right = null;
        }
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(2);
        System.out.println(isUniVal(root));
        System.out.println(isUniVal(root,root.val));
    }
    private static boolean isUniVal(TreeNode root) {
        if(root==null) return true;
        return ((root.left ==null ||root.val == root.left.val) &&
                (root.right == null || root.val == root.right.val) &&
                isUniVal(root.left) &&
                isUniVal(root.right));
    }
    private static boolean isUniVal(TreeNode root,int val) {
        if(root==null) return true;
        return ((root.val == val) &&
                (root.val == val) &&
                isUniVal(root.left,val) &&
                isUniVal(root.right,val));
    }
}

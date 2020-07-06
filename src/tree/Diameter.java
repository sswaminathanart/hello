package tree;

import java.util.StringTokenizer;

public class Diameter {
    public static void main(String[] args) {
        String tree = "{0,0}";
        int ans = 0;

        diameter_of_a_tree(tree, ans);


    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int value) {
            this.val = value;
        }
    }

    static Node createTree(String data) {
        if (data == null || data.length() == 0)
            return null;
        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }

    static Node deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens())
            return null;
        String s = st.nextToken();
        if (s.equals("#"))
            return null;
        Node root = new Node(Integer.valueOf(s));
        root.left = deserialize(st);
        root.right = deserialize(st);

        return root;
    }

    static void diameter_of_a_tree(String tree, int ans) {
        Node root = createTree(tree);
        int diameter = diameter_of_a_tree_helper(root);
        ans = diameter;
        System.out.println(ans);
    }

    static int diameter_of_a_tree_helper(Node root) {
        if (root == null)
            return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);
        int ldiameter = diameter_of_a_tree_helper(root.left);
        int rdiameter = diameter_of_a_tree_helper(root.right);
        return Math.max(Math.max(ldiameter,
                rdiameter),
                lheight + rheight + 1);
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        return 1 + Math.max(lheight, rheight);
    }
}

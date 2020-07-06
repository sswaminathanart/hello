package tree;

public class PostOrderToBST {
    static int[] arr ={840, 1508, 4417, 1946, 4584, 1675, 6538, 8666, 7735, 6320};
    /*
    Itr 1
    Root - 6320
    right 6538, 8666, 7735
    left 840, 1508, 4417, 1946, 4584, 1675
    Itr2
                    6320
               1675               7735
                          6538             8666
          right 4417, 1946, 4584
          left   840, 1508

                 1675
            1508         4584
        840          1946
                       4417
     */
    public static TreeNode postOrderToTree(int start,int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(arr[end]);
        int right_end =-1;
        for(int i= end-1;i>=0;i--) {
            if(arr[i] >arr[end]) {
                right_end = i;
            }
            else break;
        }if(right_end !=-1) {
            root.right = postOrderToTree(right_end, end - 1);
            root.left = postOrderToTree(start, right_end - 1);
        }else {
            root.left = postOrderToTree(start, end - 1);
        }

        return root;
    }
    static void bfs(TreeNode root){
        if(root == null) {
            return;
        }
        bfs(root.left);
        System.out.println( root.key);
        bfs(root.right);

    }
    static class Index {
        int indexValue;
    }
    static TreeNode postorderToTreeOofn(Index index,int currVal,int min,int max) {
        if(index.indexValue <0) {
            return null;
        }
        TreeNode root = null;
        if (min<currVal && currVal <max) {
            root = new TreeNode(arr[index.indexValue]);
            index.indexValue = index.indexValue -1;
            if(index.indexValue >=0) {
                root.right = postorderToTreeOofn(index, arr[index.indexValue],currVal,max );
                root.left =  postorderToTreeOofn(index,arr[index.indexValue],min,currVal);
            }
        }
        return root;

    }
    static boolean isBST(TreeNode root,int min,int max) {
        return root==null || (min <= root.key && root.key <=max && isBST(root.left,min,root.key) && isBST(root.right,root.key,max));
    }
    public static void main(String args[]) {
        TreeNode root = postOrderToTree(0,arr.length-1);
        Index idx =new Index();
        idx.indexValue = arr.length-1;
        root =postorderToTreeOofn(idx,arr[idx.indexValue],Integer.MIN_VALUE,Integer.MAX_VALUE);
        bfs(root);
        System.out.println(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
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

package tree;

import java.util.Arrays;


public class ConstructTreeFromInorderAndPostorder {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if (len == 0) return null;
        if (len == 1) return new TreeNode(inorder[0]);
        int i = postorder.length - 1;
        while (i>=0 && postorder[len - 1] != inorder[i]) {
            i--;
        }
        TreeNode parent = new TreeNode(inorder[i]);
        parent.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        parent.right = buildTree(Arrays.copyOfRange(inorder, i+1, len), Arrays.copyOfRange(postorder, i, len-1));
        return parent;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

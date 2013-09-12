package tree;

public class MinDepth {
	
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int l = Integer.MAX_VALUE;
        if(root.left != null) {
            l = minDepth(root.left);
        }
        int r = Integer.MAX_VALUE;
        if(root.right != null) {
            r = minDepth(root.right);
        }
        return Math.min(l, r) + 1;
    }

}

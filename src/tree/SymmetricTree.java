package tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null || left.val != right.val) {
            return false;
        }
        
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        
    }

}

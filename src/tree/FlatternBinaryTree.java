package tree;

public class FlatternBinaryTree {
    public void flatten(TreeNode root){
        if(root == null) return;
        f(root);
        
    }
    
    TreeNode f(TreeNode root){
        TreeNode right = root.right;
        TreeNode left = root.left;
        if(left == null && right == null) return root;
        
        TreeNode last = null;
        if(left != null){
            root.right = left;
            root.left = null;
            last = f(left);
        }
        if(last != null){
            last.right = right;
        } 
        
        if(right == null){
            return last;
        }
        return f(right);
    }

}

package tree;

public class CheckBalance {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
     }
     
     int getHeight(TreeNode root){
         if(root == null) return 0;
         
         int l = getHeight(root.left);
         
         // Move to here to improve efficiency
         if( l == -1) return -1;

         int r = getHeight(root.right);
         
         if(r == -1 || l-r > 1 || r-l > 1) return -1;
         
         return Math.max(l, r) + 1;
     }

}

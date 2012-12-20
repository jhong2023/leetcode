package tree;


public class BinaryTreeMaximumPathSum {
    
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

  int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        if (root == null) return 0;
        pathSumFromRoot(root);
        return maxSum;
    }
    
    private int pathSumFromRoot(TreeNode root) {
        
        int sum  = root.val;
        
        int lResult = 0;
        if (root.left != null) {
            lResult = pathSumFromRoot(root.left);
        }
        
        int rResult = 0;
        if (root.right != null) {
            rResult = pathSumFromRoot(root.right);
         }
        
        if (lResult < 0) {
           lResult = 0;
        }
        
        if (rResult < 0) {
            rResult = 0;
        }
        
        int tmpSum  = sum + lResult;
        tmpSum = tmpSum + rResult;
        if (tmpSum > maxSum) maxSum = tmpSum;

             
        if (lResult > rResult) {
            sum += lResult;
        } else {
            sum += rResult;
        }

        return sum;
    }
}

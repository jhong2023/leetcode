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
    
    /////////  #####################   /////////////
    
    class Res{
        int max;
        int maxRoot;
    }
    public int maxPathSum___(TreeNode root) {
        Res r = maxPathSum_(root);
        return r.max;
    }
    
    Res maxPathSum_(TreeNode root) {
        Res r = new Res();
        if(root == null){
            r.maxRoot = 0;
            r.max = Integer.MIN_VALUE;
            return r;
        }
        Res rl = maxPathSum_(root.left);
        Res rr = maxPathSum_(root.right);
        
        r.maxRoot = 
            Math.max(0, Math.max(rl.maxRoot, rr.maxRoot) + root.val);
        r.max = Math.max(
            rl.maxRoot + rr.maxRoot + root.val, Math.max(rl.max, rr.max));
        return r;
    }
}

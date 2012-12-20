package tree;

public class CheckBalance {

    class Result{
        boolean isBalace;
        int longestPath;
        int smallestPath;
    }
    
    class Node{
        int val;
        Node left;
        Node right;
    }
    
    boolean checkBalance(Node root) {
        return checkBalance_(root).isBalace;
    }
    
    Result checkBalance_(Node root) {
        Result result = new Result();
        if (root == null) {
            result.longestPath = 0;
            result.smallestPath = 0;
            result.isBalace = true;
            return result;
        }
        
        Result lResult = checkBalance_(root.left);
        if (!lResult.isBalace) {
            result.isBalace = false;
            return result;
        }
        Result rResult = checkBalance_(root.right);
        if (!rResult.isBalace) {
            result.isBalace = false;
            return result;
        }
        
        result.longestPath = Math.max(lResult.longestPath, rResult.longestPath) + 1;
        result.smallestPath = Math.min(lResult.smallestPath, rResult.smallestPath) + 1;
        if (result.longestPath - result.smallestPath > 1) {
            result.isBalace = false;
        } else {
            result.isBalace = true;
        }
        result.isBalace = true;
        return result;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

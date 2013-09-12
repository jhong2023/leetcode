package tree;

import java.util.Stack;

class ThreadTreeNode{
	ThreadTreeNode left;
	ThreadTreeNode right;
	boolean isLeftThread;
	boolean isRightThread;
}
public class ThreadedBinaryTree {
	    public void convertToThreadedTree(ThreadTreeNode root) {
	        if(root == null) return;
	        convert(root, null, null);
	    }
	    
	    void convert(ThreadTreeNode root, ThreadTreeNode pre, ThreadTreeNode next){
	        if(root.left == null){
	            root.left = pre;
	            root.isLeftThread  = true;
	        } else {
	            convert(root.left, pre, root);
	        }
	        
	        if(root.right == null){
	            root.right = next;
	            root.isRightThread  = true;
	        } else {
	            convert(root.right, root, next);
	        }
	        
	    }
	    
	    public void convertToThreadedTree_(ThreadTreeNode root) {
	        if(root == null) return;
	        Stack<ThreadTreeNode> s = new Stack<ThreadTreeNode>();
	        ThreadTreeNode n = root;
	        ThreadTreeNode pre = null;
	        while(true){
	            while(n != null){
	                s.push(n);
	                n = n.left;
	            }
	            if(s.isEmpty()) break;
	            n = s.pop();
	            if(n.left == null){
	                n.left = pre;
	                n.isLeftThread  = true;
	            }
	            // set previous node
	            pre = n;
	            
	            if(n.right == null){
	            	if(!s.isEmpty()){
		                n.right = s.peek();
		                n.isLeftThread  = true;
		            }
	            	// set to null to avoid dead loop
	            	n = null;
	            } else {
	            	n = n.right;
	            }
	        }
	    }

}

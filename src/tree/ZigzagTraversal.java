package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ZigzagTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(root == null) return res;
    	
    	Stack<TreeNode> s1 = new Stack<TreeNode>();
    	Stack<TreeNode> s2 = new Stack<TreeNode>();
    	boolean reverse = false;
    	s1.push(root);
    	while(!s1.isEmpty()){
    		ArrayList<Integer> a = new ArrayList<Integer>();
    		while(!s1.isEmpty()){
	    		TreeNode n = s1.pop();
	    		a.add(n.val);
	    		if(reverse){
	    			if(n.right != null){
	    				s2.push(n.right);
	    			}
	    			if(n.left != null){
	    				s2.push(n.left);
	    			}
	    		} else {
	    			if(n.left != null){
	    				s2.push(n.left);
	    			}
	    			if(n.right != null){
	    				s2.push(n.right);
	    			}
	    		}
    		}
    		reverse = !reverse;
    		res.add(a);
    		Stack<TreeNode> tmp = s1;
    		s1 = s2;
    		s2 = tmp;
    		// This clear will clear s1 too, as s1 and s2 point to same stack
    		// s2.clear();
    	}
    	
        return res;
    }
    
    public static void main(String[] args) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('a', 1);
		m.put('a', 2);
		System.out.println(m.get('a'));
	}

}
